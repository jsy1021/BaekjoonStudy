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
#include<vector>
using namespace std;
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
int N;
bool rangeCheck(int x, int y) {
	return (0 <= x && x < N && 0 <= y && y < N);
}void snail(vector<vector<int>>&arr) {
	int x = 0, y = 0, dir = 0;//시작 위치와 초기 방향 설정(초기방향은 우)
	for (int i = 1; i <= N*N; i++) {
		arr[x][y] = i;

		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if (!rangeCheck(nx, ny) || arr[nx][ny] != 0) {
			dir = (dir + 1) % 4;
			nx = x + dx[dir];
			ny = y + dy[dir];
		}
		x = nx;
		y = ny;
	}
}
int main() {
	int TC;
	cin >> TC;
	for (int i = 1; i <= TC; i++) {
		cin >> N;
		vector<vector<int>>arr(N, vector<int>(N, 0));
		snail(arr);

		cout << "#" << i << endl;
		for (auto row : arr) {
			for (int num : row) {
				cout << num << " ";
			}
			cout << endl;
		}
	}
	
	return 0;
}