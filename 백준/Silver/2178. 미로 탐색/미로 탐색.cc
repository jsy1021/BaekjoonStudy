#include<iostream>
#include<queue>
#include<string>
#define MAX 101

using namespace std;

int n, m;
int arr[MAX][MAX];
int visited[MAX][MAX];
int dist[MAX][MAX];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
queue<pair<int, int>>q;
void bfs(int start_x, int start_y) {

	visited[start_x][start_y] = 1;
	q.push(make_pair(start_x, start_y));
	dist[start_x][start_y]++;
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if ((0 <= nx && nx < n) && (0 <= ny && ny < m)
				&& !visited[nx][ny] && arr[nx][ny] == 1) {
				visited[nx][ny] = 1;
				q.push(make_pair(nx, ny));
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
	}
}
int main() {
	
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		string row;
		cin >> row;
		for (int j = 0; j < m; ++j) {
			arr[i][j] = row[j] - '0';
		}
	}
	bfs(0, 0);
	cout << dist[n - 1][m - 1];
	
}