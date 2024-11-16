#include<iostream>
#include<unordered_map>
#include<vector>
#include<algorithm>
using namespace std;
bool compare(const pair <int, int>& a, const pair<int, int>& b) {
	if (a.second == b.second) {
		return a.first > b.first;
	}
	return a.second > b.second;
}
int main() {
	int TC;
	cin >> TC;
	for (int i = 1; i <= TC; i++) {
		int n;
		cin >> n;
		vector<int>score(1000);
		unordered_map<int, int>m;
		for (int j = 0; j < 1000; j++) {
			cin >> score[j];
			m[score[j]]++;
		}
		vector<pair<int, int>> vec(m.begin(), m.end());
		sort(vec.begin(), vec.end(), compare);
		cout << "#"<<i<<" "<<vec[0].first << endl;
	}
	return 0;
}