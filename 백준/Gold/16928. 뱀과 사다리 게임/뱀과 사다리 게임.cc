#include<iostream>
#include<queue>

using namespace std;
int map[101] = { 0 };
bool visited[101] = { 0 };
void game(int location, int count) {
	queue<pair<int, int>> q;
	q.push(make_pair(location, count));
	while (!q.empty()) {
		int loc = q.front().first;
		int cnt = q.front().second;
		q.pop();
		
		for (int i = 1; i <= 6; i++) {
			int nx = loc + i; //다음 좌표
			if (nx == 100) {
				cout << cnt + 1;// 도착시 출력후 종료
				return;
			}
			else if (nx < 100) {
				while (map[nx] != 0) {
					nx = map[nx]; //점프한 자리로 이동
				}
				if (!visited[nx]) {
					q.push({ nx,cnt + 1 });
					visited[nx] = true;//방문처리
				}
			}
		}
	}
}
int main() {
	int n, m, w1,w2;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> w1 >> w2;
		map[w1] = w2;//사다리 저장
	}
	for (int i = 0; i < m; i++) {
		cin >> w1 >> w2;
		map[w1] = w2;// 뱀 저장
	}
	game(1, 0);
	
	return 0;
}