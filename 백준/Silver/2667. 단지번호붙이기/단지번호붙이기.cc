#include <iostream>
#include <algorithm>
#define MAX 25
using namespace std;
int graph[MAX][MAX] = { 0, };
int complex[MAX] = { 0, };
int x_dir[4] = { 1, -1, 0, 0 };
int y_dir[4] = { 0, 0, 1, -1 };
int N;

//DFS
int DFS(int i, int j) {
    graph[i][j] = 0;
    int cnt = 1;
    for (int k = 0; k < 4; k++) {
        int x = i + x_dir[k];
        int y = j + y_dir[k];
        if (0 <= x and x < N and 0 <= y and y < N) {
            if (graph[x][y] == 1) {
                cnt += DFS(x, y);
            }
        }
    }
    return cnt;
}
int main() {
    cin >> N;
    string nums;
    //그래프 생성
    for (int i = 0; i < N; i++) {
        cin >> nums;
        for (int j = 0; j < N; j++) {
            graph[i][j] = nums[j] - '0';
        }
    }

    //단지내의 새대 수 저장
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (graph[i][j] == 1) {
                complex[cnt] = DFS(i, j);
                cnt++;
            }
        }
    }

    //단지 오름차순으로 정렬
    sort(complex, complex + cnt);

    //출력
    cout << cnt << endl;
    for (int i = 0; i < cnt; i++) cout << complex[i] << endl;

    return 0;
}