#include<iostream>
#define MAX 101
using namespace std;
int N, M;
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
int map[MAX][MAX];
int result;
bool range(int x, int y) {
	return (x >= 0 && x < N && y >= 0 && y < M);
}
int count(int x, int y) {
	int count = 0;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (range(nx, ny)) {
			if (map[nx][ny] < map[x][y])
				count += (map[x][y] - map[nx][ny]);
		}
		else
			count += map[x][y];
	}
	return count;
}
int main() {
	cin >> N >> M;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			result+=count(i, j);
		}
	}
	result += (N * M) * 2;
	cout << result << endl;
	return 0;
}