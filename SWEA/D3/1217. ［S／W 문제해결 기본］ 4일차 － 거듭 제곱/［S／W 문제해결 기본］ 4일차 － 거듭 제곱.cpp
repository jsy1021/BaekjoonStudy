#include<iostream>
using namespace std; 
int recursion(int number,int count) {
	int result = 1;
	for (int i = 0; i < count; i++) {
		result *= number;
	}
	return result;
}
int main() {
	for (int tc = 1; tc <= 10; tc++) {
		int num;
		int n,m;
		cin >> num;
		cin >> n>>m;
		recursion(n, m);
		cout << "#" << tc << " " << recursion(n, m) << endl;
	}
	return 0;
}