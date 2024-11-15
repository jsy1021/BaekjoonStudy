#include<iostream>
#include<string>
using namespace std;

int main() {
	for (int tc = 1; tc <= 10; tc++) {
		int n;
		int cnt = 0;
		cin >> n;
		string search;
		string str;
		cin >> search;
		cin >> str;
		int index = str.find(search);
		while (index != string::npos) {
			cnt++;
			index=str.find(search, index+ search.length());
			
		}
		cout << "#" << tc << " " << cnt << endl;
	}
	return 0;
}