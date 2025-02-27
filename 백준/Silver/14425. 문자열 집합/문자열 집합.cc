#include<iostream>
#include<unordered_set>
#include<string>

using namespace std;

int main() {
	int N, M;
	int count = 0;
	unordered_set<string>s;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;
		s.insert(str);
	}
	for (int i = 0; i < M; i++) {
		string str;
		cin >> str;
		auto it = s.find(str);
		if(it!=s.end())
			count++;
	}
	cout << count << endl;
	return 0;
}