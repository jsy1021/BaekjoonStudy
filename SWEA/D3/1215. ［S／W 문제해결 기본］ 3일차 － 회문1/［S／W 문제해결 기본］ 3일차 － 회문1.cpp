#include<iostream>
#include<vector>
using namespace std;
int main() {
	for (int tc = 1; tc <= 10; tc++) {
		int n;
		int cnt = 0;
		cin >> n;
		vector<vector<char>>arr(8, vector<char>(8));
		for (int i = 0; i < 8; i++) {
			string str;
			cin >> str;
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str[j];
			}
		}
		//처리부
		//가로 먼저 처리
		string front, rear;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j <= 8 - n; j++)
			{
				bool is_palindrome = true;
				for (int k = 0; k < n / 2; k++) {
					if (arr[i][j + k] != arr[i][j + n - k - 1]) {
						is_palindrome = false;
						break;
					}
				}
				if (is_palindrome) {
					cnt++;
				}
			}
		}
		//세로 처리
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i <= 8 - n; i++) {
				bool is_palindrome = true;
				for (int k = 0; k < n / 2; k++) {
					if (arr[i + k][j] != arr[i + n - k - 1][j]) {
						is_palindrome = false;
						break;
					}
				}
				if (is_palindrome) {
					cnt++;
				}
			}
		}
		cout << "#" << tc << " " << cnt << endl;
	}
	return 0;
}