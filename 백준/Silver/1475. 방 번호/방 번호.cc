//백준 1475번 방 번호
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int arr[10] = {0,};
	int n;
	cin >> n;
	while (n > 0) {
		if (n % 10 == 6 || n % 10 == 9) {
			if (arr[6] == arr[9])
				arr[6]++;
			else arr[9]++;
		}
			else {
				arr[n % 10]++;
			
		}
		n /= 10;
	}
	int size = sizeof(arr) / sizeof(arr[0]);
	int maxValue = *max_element(arr, arr + size);
	cout << maxValue;
	return 0;
}