/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// float b, c;
// double d, e, f;
// char g;
// char var[256];
// long long AB;
// cin >> a;                            // int 변수 1개 입력받는 예제
// cin >> b >> c;                       // float 변수 2개 입력받는 예제 
// cin >> d >> e >> f;                  // double 변수 3개 입력받는 예제
// cin >> g;                            // char 변수 1개 입력받는 예제
// cin >> var;                          // 문자열 1개 입력받는 예제
// cin >> AB;                           // long long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// float b = 1.0, c = 2.0;               
// double d = 3.0, e = 0.0; f = 1.0;
// char g = 'b';
// char var[256] = "ABCDEFG";
// long long AB = 12345678901234567L;
// cout << a;                           // int 변수 1개 출력하는 예제
// cout << b << " " << c;               // float 변수 2개 출력하는 예제
// cout << d << " " << e << " " << f;   // double 변수 3개 출력하는 예제
// cout << g;                           // char 변수 1개 출력하는 예제
// cout << var;                         // 문자열 1개 출력하는 예제
// cout << AB;                          // long long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

#define N 100
#define K 1000

using namespace std;

struct Node {
	int cnt = 0;   // 미생물 수
	int dir = 0;   // 진행 방향
};

int n, m, k;
Node cellMap[N + 1][N + 1];
const int direction[5][2] = { {0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

void move() {
	// 현재 위치의 변화를 임시로 저장할 맵을 사용
	Node temp_map[N + 1][N + 1] = { 0 };
	int max_cnt[N + 1][N + 1] = { 0 };  // 최대 미생물 수를 추적

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (cellMap[i][j].cnt > 0) { // 미생물이 존재할 경우
				int dir = cellMap[i][j].dir;
				int next_x = i + direction[dir][0];
				int next_y = j + direction[dir][1];

				// 약품 처리된 가장자리
				if (next_x == 0 || next_x == n - 1 || next_y == 0 || next_y == n - 1) {
					int new_cnt = cellMap[i][j].cnt / 2; // 절반으로 감소
					int new_dir = (dir == 1) ? 2 : (dir == 2) ? 1 : (dir == 3) ? 4 : 3;

					if (new_cnt > 0) {
						temp_map[next_x][next_y].cnt += new_cnt;
						temp_map[next_x][next_y].dir = new_dir;
					}
				}
				// 일반적인 이동
				else {
					temp_map[next_x][next_y].cnt += cellMap[i][j].cnt;

					// 최대값이 변경될 때만 방향 갱신
					if (cellMap[i][j].cnt > max_cnt[next_x][next_y]) {
						max_cnt[next_x][next_y] = cellMap[i][j].cnt;
						temp_map[next_x][next_y].dir = cellMap[i][j].dir;
					}
				}
			}
		}
	}

	// 이동 후 임시 맵을 원래 맵으로 복사
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cellMap[i][j] = temp_map[i][j];
		}
	}
}

int getAnswer() {
	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			sum += cellMap[i][j].cnt;
		}
	}
	return sum;
}

int main() {
	int T;
	cin >> T;

	for (int t = 1; t <= T; t++) {
		cin >> n >> m >> k;

		// 초기화
		for (int i = 0; i < n; i++) {
			fill(cellMap[i], cellMap[i] + n, Node{ 0, 0 });
		}

		// 입력받기
		for (int i = 0; i < k; i++) {
			int x, y, cnt, dir;
			cin >> x >> y >> cnt >> dir;
			cellMap[x][y] = { cnt, dir };
		}

		// m번 이동
		for (int i = 0; i < m; i++) {
			move();
		}

		cout << "#" << t << " " << getAnswer() << endl;
	}

	return 0;
}