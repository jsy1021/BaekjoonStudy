#include<iostream>

using namespace std;
int N, M;
int arr[9];
bool visited[9];
void func(int num=1, int k=0) {
	if (k == M) {
		for (int i = 0; i < M; i++) 
			cout << arr[i] << ' ';
		cout << "\n";
		return;
	}
	for (int i = num; i <= N; i++) {
		if (!visited[i]) {
			arr[k] = i;
			visited[i] = true;
			func(i + 1, k + 1);
			visited[i] = false;
		}
	}
}
int main() {
	cin >> N >> M;
	func(1, 0);
	return 0;
}