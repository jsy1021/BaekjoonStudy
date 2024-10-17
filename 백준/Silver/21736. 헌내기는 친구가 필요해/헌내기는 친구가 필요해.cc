#include<iostream>
#include<vector>
#include<queue>
#include<string>

using namespace std;

int dx[] = { 0,1,0,-1 };
int dy[] = { -1,0,1,0 };
int n, m;

// 좌표가 범위 내에 있는지 확인하는 함수
bool range(int y, int x) {
    return (0 <= y && y < n && 0 <= x && x < m);
}

int main() {
    cin >> n >> m;
    vector<vector<bool>> visited(n, vector<bool>(m, false));  // 방문 여부 확인용 배열
    vector<string> arr;
    int now_x, now_y;
    int cnt = 0;

    // 배열 입력 받기
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        arr.push_back(str);
    }

    // 'I' 위치 찾기
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] == 'I') {
                now_y = i;
                now_x = j;
            }
        }
    }

    // BFS 탐색을 위한 큐 선언 및 초기값 삽입
    queue<pair<int, int>> q;
    q.push({ now_y, now_x });
    visited[now_y][now_x] = true;

    // BFS 시작
    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();
        int y = now.first;
        int x = now.second;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int pos_y = y + dy[i];
            int pos_x = x + dx[i];

            // 좌표가 유효한지 먼저 확인해야 함 (range 검사 먼저)
            if (range(pos_y, pos_x) && arr[pos_y][pos_x] != 'X' && !visited[pos_y][pos_x]) {
                if (arr[pos_y][pos_x] == 'P') {
                    cnt++;  // 'P'를 발견하면 카운트 증가
                }
                q.push({ pos_y, pos_x });  // 다음 탐색 좌표 추가
                visited[pos_y][pos_x] = true;  // 방문 처리
            }
        }
    }

    // 결과 출력
    if (cnt == 0) {
        cout << "TT";
    }
    else {
        cout << cnt;
    }

    return 0;
}