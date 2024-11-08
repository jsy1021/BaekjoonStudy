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

#include<iostream>
#define N 100
#define K 1000
using namespace std;
typedef struct {
	int cnt;// 미생물 수
	int dir; //진행 방향
	int maxcnt;
}node;
int n, m, k;
node map[N + 1][N + 1];
node next_map[N + 1][N + 1];
int direction[5][2] = { {0,0},{-1,0},{1,0},{0,-1},{0,1} };
void move() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j].cnt > 0)//미생물이 존재할 경우
			{
				int dir = map[i][j].dir;
				int next_x = i + direction[dir][0];
				int next_y = j + direction[dir][1];

				//약품 처리된 곳을 갈 경우
				if (next_x == 0 || next_x == n - 1 || next_y == 0 || next_y == n - 1) {
					next_map[next_x][next_y].cnt = map[i][j].cnt / 2;
					if (dir == 1)
						next_map[next_x][next_y].dir = 2;
					else if (dir == 2)
						next_map[next_x][next_y].dir = 1;
					else if (dir == 3)
						next_map[next_x][next_y].dir = 4;
					else if (dir == 4)
						next_map[next_x][next_y].dir = 3;
				}
				//일반 좌표를 갈 경우
				else {
					if (next_map[next_x][next_y].maxcnt > 0) {
						next_map[next_x][next_y].cnt += map[i][j].cnt;//미생물 합산
						
						if (next_map[next_x][next_y].maxcnt < map[i][j].cnt) {
							next_map[next_x][next_y].maxcnt = map[i][j].cnt;
							next_map[next_x][next_y].dir = map[i][j].dir;
						}
					}
					else {
						next_map[next_x][next_y].cnt = map[i][j].cnt;
						next_map[next_x][next_y].maxcnt = next_map[next_x][next_y].cnt;
						next_map[next_x][next_y].dir = map[i][j].dir;
					}
				}
			}
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			map[i][j] = next_map[i][j];
			next_map[i][j] = { 0,0,0 };
		}
	}
}
int getAnswer() {
	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			sum += map[i][j].cnt;
		}
	}
	return sum;
}
int main() {
	int T;
	cin >> T;
	for (int i = 1; i <= T; i++) {
		
		int x, y, cnt, dir;
		cin >> n >> m >> k;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = { 0,0,0 };
			}
		}
		for (int j = 0; j < k; j++) {
			cin >> x >> y >> cnt >> dir;
			map[x][y] = { cnt,dir,cnt };
		}
		for (int j = 0; j < m; j++) {
			move();
		}
		cout << "#" << i << " " << getAnswer() << endl;
		
	}
	return 0;
}