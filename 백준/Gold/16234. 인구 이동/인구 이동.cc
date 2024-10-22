#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
#include <cstring>

using namespace std;

int N, L, R;
int A[50][50];  // 각 나라의 인구 수
bool visited[50][50];  // 방문 여부 체크
int dx[4] = { 0, 0, -1, 1 };  // 상하좌우 방향
int dy[4] = { -1, 1, 0, 0 };

bool bfs(int x, int y) {
    vector<pair<int, int>> unionCountries;  // 연합 국가들의 좌표 저장
    queue<pair<int, int>> q;
    q.push({ x, y });
    unionCountries.push_back({ x, y });
    visited[x][y] = true;

    int totalPopulation = A[x][y];
    int unionCount = 1;

    while (!q.empty()) {
        int cx= q.front().first;
        int cy = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                int populationDiff = abs(A[cx][cy] - A[nx][ny]);
                if (populationDiff >= L && populationDiff <= R) {
                    q.push({ nx, ny });
                    unionCountries.push_back({ nx, ny });
                    visited[nx][ny] = true;
                    totalPopulation += A[nx][ny];
                    unionCount++;
                }
            }
        }
    }

    if (unionCount > 1) {
        int newPopulation = totalPopulation / unionCount;
        for (auto position : unionCountries) {
            int ux = position.first;
            int uy = position.second;
            A[ux][uy] = newPopulation;
        }
        return true;
    }
    return false;
}

int main() {
    cin >> N >> L >> R;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> A[i][j];
        }
    }

    int days = 0;

    while (true) {
        bool moved = false;
        memset(visited, false, sizeof(visited));  // 방문 기록 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j)) {
                        moved = true;
                    }
                }
            }
        }

        if (!moved) {
            break;
        }
        days++;
    }

    cout << days << endl;

    return 0;
}