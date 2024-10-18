#include<iostream>
#include<string>
#include<sstream>
#include<vector>

using namespace std;

int main() {
	int n;
	cin >> n;
	cin.ignore();
	vector<vector<int>>graph(n);
	for (int i = 0; i < n; i++) {
		string line;
		getline(cin, line);
	
		istringstream stream(line);
		int number;
		while (stream >> number) {
			graph[i].push_back(number);
		}
	}
	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][k] == 1 && graph[k][j]==1) {
					graph[i][j] = 1;
				}
			}
		}
	}

	for (const auto& row : graph) {
		for (const auto& num : row) {
			cout << num << " ";
		}
		cout << endl;
	}
	return 0;
}