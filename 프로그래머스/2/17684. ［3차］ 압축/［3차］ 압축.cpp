#include<iostream>
#include<vector>
#include<string>
#include<unordered_map>

using namespace std;

vector<int>solution(string msg) {
	vector<int>answer;
	unordered_map<string, int> alpabet;
	int num = 1;
	for (char C = 'A'; C <= 'Z';C++) {
		string str = ""; str += C;
		alpabet[str] = num++;
	}
	
	string current = "";
	for (int i = 0; i < msg.length(); i++) {
		current += msg[i];
		if (alpabet[current] == 0) {
			alpabet[current] = num++;
			current = current.substr(0, current.length() - 1);
			answer.push_back(alpabet[current]);
			current = "";
			i--;
		}
	}
	answer.push_back(alpabet[current]);
	return answer;
}