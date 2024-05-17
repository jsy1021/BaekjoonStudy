#include<iostream>
using namespace std;

int test_case, N;
int cnt = 0;
int dp[12] = { 0, };

int main() {

	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	cin >> test_case;

	for (int i = 0; i < test_case; i++) {
		cin >> N;
		cnt = 0;
		for (int i = 4; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		cout << dp[N] << endl;

	}


	return 0;
}