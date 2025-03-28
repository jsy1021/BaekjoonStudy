#include<iostream>

using namespace std;
int N, M;
int arr[10];
bool isused[10];
void func(int k) {
	if (k == M) {
		for (int i = 0; i < M; i++)
			printf("%d ", arr[i]);
		printf("\n");
		return;
	}
	for (int i = 1; i <= N; i++) {
		if (!isused[i]) {
			arr[k] = i;
			isused[i] = 1;
			func(k + 1);
			isused[i] = 0;
		}
	}
	return;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> N >> M;
	func(0);
	return 0;
}