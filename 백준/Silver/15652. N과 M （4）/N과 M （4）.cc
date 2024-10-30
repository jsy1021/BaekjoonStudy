#include<iostream>
int N, M;
int arr[10];
using namespace std;
void dfs(int num, int k) {
	if (k == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	else {
		for (int i = num; i <= N; i++) {
			arr[k] = i;
			dfs(i, k + 1);
		 }
	}
}
int main() {
	cin >> N >> M;
	dfs(1, 0);
	return 0;
}