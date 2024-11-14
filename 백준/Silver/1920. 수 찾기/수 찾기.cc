#include<iostream>
#include<algorithm>

using namespace std;

int n,m;
int arr[100000];
void binary_search(int x) {
	int left = 0, mid = 0 , right = n - 1;
	while (left <= right) {
		mid = (left + right) / 2;
		if (arr[mid] == x) {
			cout << 1 << "\n";
			return;
		}
		else if (arr[mid] > x) {
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}
	cout << 0 << "\n";
	return;
}

int main(void) {
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);
	
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	cin >> m;

	int x;
	for (int i = 0; i < m; i++) {
		cin >> x;
		binary_search(x);
	}
	
	return 0;
}