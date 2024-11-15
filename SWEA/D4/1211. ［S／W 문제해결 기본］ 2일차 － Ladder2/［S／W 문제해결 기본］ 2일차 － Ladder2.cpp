#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<vector<int>>arr(100, vector<int>(100));
int cnt;
void bfs(int startY, int startX,vector<pair<int,int>>&result) {
	int x = startX;
	cnt = 0;
	while (startY > 0) {
		if (x - 1 >= 0 && arr[startY][x - 1] == 1) {
			while (x - 1 >= 0 && arr[startY][x - 1] == 1) {
				x--;
				cnt++;
			}
		}
		else if (x + 1 < 100 && arr[startY][x + 1] == 1) {
			while (x + 1 < 100 && arr[startY][x + 1] == 1)
			{
				x++;
				cnt++;
			}
		}
		startY--;
		cnt++;
	}
	result.push_back({ cnt,x });
}
int main() {
	for (int tc = 1; tc <= 10; tc++) {
		int n;
		cin >> n;
		vector<pair<int, int>>result;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				cin >> arr[i][j];
			}
		}
		//처리부
		for (int i = 0; i < 100; i++) {
			if (arr[99][i] == 1) {
				bfs(99, i, result);
			}
		}
		sort(result.begin(), result.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
			if (a.first != b.first) {
				return a.first < b.first;
			}
			return a.second > b.second;
		});
		cout << "#" << tc << " " << result[0].second<<endl;
	}
	return 0;
}