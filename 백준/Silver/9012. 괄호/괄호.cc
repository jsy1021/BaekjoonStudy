#include<iostream>
#include<string>
#include<stack>

using namespace std;
bool solution(string str) {
	stack<char>st;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == '(')
		{
			st.push(str[i]);
		}
		else if (str[i] == ')') {
			if (st.empty()) {
				return false;
			}
			st.pop();
		}
	}
	return st.empty();
}
int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		string str;
		cin >> str;
		bool result = solution(str);
		if (result) {
			cout << "YES"<<endl;
		}
		else {
			cout << "NO" << endl;
		}
	}
	return 0;
}