#include<iostream>
#include<vector>
#include<string>
#include<map>

using namespace std;

int main() {
	int listen, see;
	map<string, int>people;
	vector<string>result;
	cin >> listen >> see;
	for (int i = 0; i < listen; i++) {
		string name;
		cin >> name;
		people[name]++;
	}
	for (int i = 0; i < see; i++) {
		string name;
		cin >> name;
		people[name]++;
	}
	for (auto&i: people) {
		if (i.second==2) {
			result.push_back(i.first);
		}
	}
	cout << result.size() << endl;
	for (const string& name : result) {
		cout << name << endl;
	}
	return 0;
}