#include<iostream>
#include<vector>
#include<algorithm>


using namespace std;
vector<int>nums;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n, m;
	cin >> n >> m;
	nums = vector<int>(n + m);
	for (int i = 0; i < n + m; i++) {
		cin >> nums[i];
	}
	sort(nums.begin(), nums.end());
	for (int i = 0; i < nums.size(); i++) {
		cout << nums[i]<<" ";
	}
	return 0;
}