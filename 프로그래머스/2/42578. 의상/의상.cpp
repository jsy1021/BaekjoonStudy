#include <string>
#include <vector>
#include<unordered_map>
using namespace std;

int solution(vector<vector<string>>clothes) {
	int answer = 1;
	unordered_map<string, int> result;
	for (auto p : clothes)
		result[p[1]]++;
	for (auto param : result) {
		answer *= (param.second + 1);
	}
	return answer-1;
}