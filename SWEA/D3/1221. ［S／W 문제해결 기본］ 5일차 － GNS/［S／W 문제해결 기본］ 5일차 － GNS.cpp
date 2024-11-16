#include<iostream>
#include<unordered_map>
#include<vector>
#include<algorithm>
using namespace std;

unordered_map<string, int>GNS = { {"ZRO", 0}, {"ONE", 1}, {"TWO", 2}, {"THR", 3},
		{"FOR", 4}, {"FIV", 5}, {"SIX", 6}, {"SVN", 7},
		{"EGT", 8}, {"NIN", 9} };
bool compare(const string& a, const string& b) {
	return GNS[a] < GNS[b];// 값이 클 때 참 반환
}
int main() {
	int TC;
	cin >> TC;
	for (int i = 1; i <= TC; i++) {
		string num;
		int count;
		cin >> num>>count;
		vector<string>arr;
		string word;
		for (int j = 0; j < count; j++) {
			cin >> word;
			arr.push_back(word);

		}
		sort(arr.begin(), arr.end(), compare);
		cout << "#"<<i << endl;
		for (const string& s : arr) {
			cout << s << " ";
		}
		cout << endl;
		
	}
	return 0;
}