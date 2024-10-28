#include<iostream>
#include<vector>

using namespace std;
int main() {
	vector<int>arr;
	vector<int>out;
	int N;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		arr.push_back(i);
	}
	while (arr.size() != 1) {
		out.push_back(arr.front());
		arr.erase(arr.begin());
		arr.push_back(arr.front());
		arr.erase(arr.begin());
	}
	for (auto num : out) {
		cout << num << " ";
	}
	cout << arr.front();
	return 0;
}