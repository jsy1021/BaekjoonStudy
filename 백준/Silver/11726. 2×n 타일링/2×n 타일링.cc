#include<iostream>
using namespace std;
int main(void) {
	int dp[1001];
	int n;
	cin >> n;
	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 2;

	for (int i = 3; i <= n; i++) {
		dp[i] = (dp[i - 1] + dp[i - 2])%10007;
	}
	
	cout << dp[n] % 10007;
}