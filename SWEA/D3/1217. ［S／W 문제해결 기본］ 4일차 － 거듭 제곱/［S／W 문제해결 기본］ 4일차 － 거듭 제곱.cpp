#include<iostream>
using namespace std; 
int main() {
	for (int tc = 1; tc <= 10; tc++) {
		int num;
		int n,m;
		int result = 1;
		cin >> num;
		cin >> n>>m;
		for (int i = 0; i < m; i++) {
			result *= n;
		}
		cout << "#" << tc << " " << result << endl;
	}
	return 0;
}