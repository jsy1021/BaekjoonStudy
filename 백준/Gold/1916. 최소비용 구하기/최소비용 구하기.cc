#include<iostream>
#include <vector>
#include<queue>
#include<climits>

using namespace std;

const int INF = INT_MAX;
int N, M;

void dijkstra(int start, const vector<vector<pair<int, int>>>& graph, vector<int>& dist) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; // 최소 비용 우선
	dist[start] = 0;
	pq.push({ 0,start });// 큐에 넣을땐 그래프의 순서와 다름 first의 값에 따라 순서가 정해짐

	while (!pq.empty()) {
		int currentDist = pq.top().first;
		int node = pq.top().second;
		pq.pop();

		if (currentDist > dist[node])
			continue;//이미 처리된 노드는 패스

		for (auto& edge : graph[node]) {
			int nextNode = edge.first;
			int cost = edge.second;
			
			if (dist[node] + cost < dist[nextNode]) {
				dist[nextNode] = dist[node] + cost;
				pq.push({ dist[nextNode],nextNode });
			}
		}
	}
	
}
int main() {
	cin >> N;
	cin >> M;
	vector<vector<pair<int, int>>> graph(N+1); //인접 리스트로 그래프 표현
	vector<int>dist(N+1, INF); //노드 수 만큼 거리 벡터 설정

	for (int i = 0; i < M; i++) {
		int a, b, cost;
		cin >> a >> b >> cost;
		graph[a].push_back({ b,cost }); //방향 그래프이므로
	}
	int start, end;
	cin >> start >> end;
	dijkstra(start, graph, dist);
	cout << dist[end]<<" ";
	return 0;
}

