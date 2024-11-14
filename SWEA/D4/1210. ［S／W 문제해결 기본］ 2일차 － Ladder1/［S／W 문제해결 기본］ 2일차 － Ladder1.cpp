#include<iostream>
#include<vector>

using namespace std;

vector<vector<int>> arr(100, vector<int>(100));

int findStartX(int startY, int startX) {
    int x = startX;

    // 도착점부터 위로 올라가면서 경로를 추적
    while (startY > 0) {
        // 1. 왼쪽으로 이동할 수 있으면 계속 왼쪽으로 이동
        if (x - 1 >= 0 && arr[startY][x - 1] == 1) {
            while (x - 1 >= 0 && arr[startY][x - 1] == 1)
                x--;
        }
        else if (x + 1 < 100 && arr[startY][x + 1] == 1) {
            
            while (x + 1 < 100 && arr[startY][x + 1] == 1)
                x++;
        }
       
        startY--;
    }

    return x;  // 도착점에서 출발점까지의 x 좌표 반환
}

int main() {
    for (int tc = 1; tc <= 10; tc++) {
        int n, x, y;
        cin >> n;

        // 배열 입력
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                cin >> arr[i][j];
            }
        }

        // 도착점 찾기 (arr[99][j]에서 2 찾기)
        for (int j = 0; j < 100; j++) {
            if (arr[99][j] == 2) {
                x = j;
                break;
            }
        }

        // 도착점에서 출발점까지 x 좌표를 찾아서 출력
        int startX = findStartX(99, x);
        cout << "#" << n << " " << startX << endl;
    }
    return 0;
}