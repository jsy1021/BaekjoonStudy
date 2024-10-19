#include<iostream>
#include<queue>

using namespace std;

int F, S, G, U, D;
queue<int>q;
bool visited[1000001];
int dist[1000001];
int find_min() {
	visited[S] = true;//시작 위치는 방문으로 체크해야함
	q.push(S);

	while (!q.empty()) {
		int current = q.front();
		q.pop();

		if (current == G)
			return dist[G];
		int up = current + U;
		int down = current - D;

		if (up <= F && !visited[up]) {
			dist[up] = dist[current] + 1;
			visited[up] = true;
			q.push(up);
		}
		if (down > 0 && !visited[down]) {
			dist[down] = dist[current] + 1;
			visited[down] = true;
			q.push(down);
		}
	}
	return -1;
}
int main() {
	cin >> F >> S >> G >> U >> D;
	int result = find_min();
	if (result == -1) {
		cout << "use the stairs";
	}
	else {
		cout << result;
	}
	return 0;
}