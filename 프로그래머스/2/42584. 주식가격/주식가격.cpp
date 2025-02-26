#include<iostream>
#include<stack>
#include<vector>
#include<queue>

using namespace std;

vector<int>solution(vector<int>prices) {
	vector<int> answer;
	queue<int>q;
	// 주식 가격들을 큐에 삽입
	for (int i = 0; i < prices.size(); i++) {
		q.push(prices[i]);
	}
	//큐에 남아있는 주식 가격을 차례대로 처리
	while (q.size()) {
		for (int i = 0; i < prices.size(); i++) {
			int tmp = q.front();
			int count = 0;// 떨어지지 않은 기간 누적 카운트
			q.pop();
			if (i + 1 < prices.size()) {
				for (int j = i + 1; j < prices.size(); j++) {
					count++;
					if (tmp > prices[j])
						break;//기준 값이 더 크다면 가격이 떨어진 것이므로 루프 종료
					
				}
			}
			answer.push_back(count);//카운트를 벡터에 저장
		}
	}
	return answer;//결과 벡터를 리턴
}
int main() {
	vector<int> ex = { 1,2,3,2,3 };
	vector<int>result = solution(ex);
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << endl;
	}
	return 0;
}