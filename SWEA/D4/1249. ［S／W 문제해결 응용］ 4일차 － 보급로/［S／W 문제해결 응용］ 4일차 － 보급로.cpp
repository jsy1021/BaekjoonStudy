#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int bfs(const pair<int, int>& start, const pair<int, int>& finish, const vector<vector<int>>& maze, int N)
{
	queue<pair<int, int>>q;
	int large_number = 1e9;
	vector<vector<int>>min_time(N, vector<int>(N, large_number));
	min_time[start.first][start.second] = 0;
	q.push(start);
	int dx[] = { 1,0,0,-1 };
	int dy[] = { 0,-1,1,0 };

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				int new_time = min_time[x][y] + maze[nx][ny];
				if (new_time < min_time[nx][ny]) {
					min_time[nx][ny] = new_time;
					q.push({ nx,ny });
				}
			}
		}
	}
	return min_time[finish.first][finish.second];
}

int main() {
	int TC;
	cin >> TC;
	for (int i = 1; i <= TC; i++) {
		int n;
		cin >> n;
		vector<vector<int>>matrix; //2차원 벡터 저장
		for (int j = 0; j < n; j++) {
			string str;
			cin >> str;
			vector<int>row;
			for (char ch : str) {
				row.push_back(ch - '0');
			}
			matrix.push_back(row);
		}
		pair<int, int>start = { 0,0 };
		pair<int, int>finish = { n - 1,n - 1 };
		cout<<"#"<<i<<" "<<bfs(start, finish, matrix, n) << endl;

	}
	return 0;
}