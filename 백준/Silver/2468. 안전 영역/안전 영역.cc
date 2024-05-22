#include<iostream>
#include<vector>
#include<algorithm>
#define MAX 101
using namespace std;
int n;
int input[MAX][MAX];
int map[MAX][MAX];
bool visited[MAX][MAX];
vector<int> v;
int cnt;
int dy[] = { 0,0,1,-1 };
int dx[] = { 1,-1,0,0 };
void DFS(int y, int x) {
	visited[y][x] = true;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny < 0 || nx < 0 || ny >= n || nx >= n)
			continue;
		if (map[ny][nx] && !visited[ny][nx]) {
			visited[ny][nx] = true;
			DFS(ny, nx);
		}
	}
}
void reset() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			map[i][j] = 0;
			visited[i][j] = 0;
		}
	}
	cnt = 0;
}
int main(void) {
	int maxheight = -1;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> input[i][j];
			if (input[i][j] > maxheight) {
				maxheight = input[i][j];
			}
		}
	}
	for (int h = 1; h <= maxheight; h++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] < h) {
					map[i][j] = 0;
				}
				else {
					map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] && !visited[i][j]) {
					DFS(i, j);
					cnt++;
				}
			}
		}
		v.push_back(cnt);
		reset();
	}
	sort(v.begin(), v.end());
	cout << v[v.size() - 1];
}