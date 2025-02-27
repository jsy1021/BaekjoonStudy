#include<iostream>
#include<vector>
using namespace std;
int search(vector<int>arr, int N, int M) {
	int result = 0;
	for (int i = 0; i < N - 2; i++) {
		for (int j = i + 1; j < N - 1; j++) {
			for (int k = j + 1; k < N; k++) {
				int temp = arr[i] + arr[j] + arr[k];

				if (M == temp) {
					return temp;
				}
				if (result < temp && temp < M) {
					result = temp;
				}
			}
		}
	}
	return result;
}
int main() {
	int N, M;
	cin >> N >> M;
	vector<int> arr(N);//c++에선 가변 배열은 불가능(컴파일 시점에 정해져야하므로 벡터 사용
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	cout << search(arr, N, M)<<endl;
	return 0;
}
