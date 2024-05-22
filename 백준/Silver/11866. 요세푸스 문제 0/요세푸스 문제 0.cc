#include<iostream>
#include<queue>
using namespace std;
int main(void) {
	queue<int>q;
	int n,k;
	cin >> n>>k;
	for (int i = 0; i < n; i++) {
		q.push(i + 1);
	}
	cout << "<";
	while (!q.empty()) {
		for (int i = 1; i < k; i++) {
			q.push(q.front());
			q.pop();
		}
		cout << q.front();
		if (q.size() != 1)
			cout << ", ";
		q.pop();
	}
	cout << ">";
}