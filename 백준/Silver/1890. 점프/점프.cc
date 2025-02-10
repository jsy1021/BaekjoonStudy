#include<iostream>
using namespace std;
int long long DP[100][100];
int main() {
    int n, board[100][100];
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
       }
    }
    DP[0][0] = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (DP[i][j] == 0)
                continue;//시작점은 패스
            if (i == n - 1 && j == n - 1)
                break;
            if (i + board[i][j] < n)
                DP[i + board[i][j]][j] += DP[i][j];
            if (j + board[i][j] < n) {
                DP[i][j + board[i][j]] += DP[i][j];
            }
        }
    }
    cout << DP[n - 1][n - 1];
    return 0;
}