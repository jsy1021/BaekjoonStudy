#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
int DP[301];
int arr[301] = { 0, };
int main(void) {
	int n;
	cin >> n;
	vector<int>arr(n);
	vector<int>dp(n, 0);
	for (int i = 0; i < n; i++)
		cin >> arr[i];

	DP[0] = arr[0];
	DP[1] = arr[0] + arr[1];
	DP[2] = max(arr[0], arr[1]) + arr[2];
	for (int i = 3; i < n; i++) {
		DP[i] = max(DP[i - 3] + arr[i - 1], DP[i - 2]) + arr[i];
	}
	cout << DP[n - 1] << '\n';
}