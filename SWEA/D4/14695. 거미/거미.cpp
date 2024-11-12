#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int T, N;
    cin >> T;

    for (int test_case = 1; test_case <= T; ++test_case) {
        cin >> N;

        // 벡터를 사용하여 x, y, z 좌표 저장
        vector<vector<long long>> points(N, vector<long long>(3));

        // 점들의 좌표 입력
        for (int i = 0; i < N; i++) {
            cin >> points[i][0] >> points[i][1] >> points[i][2];
        }

        cout << '#' << test_case;

        if (N < 4) {
            cout << " TAK\n";
        }
        else {
            bool plane = false, possible = true;
            long long a = 0, b = 0, c = 0, d = 0;

            // 첫 번째 점, 두 번째 점을 기준으로 평면 정의를 위한 벡터 계산
            for (int n = 2; n < N; n++) {
                if (!plane) {
                    // 외적 계산
                    a = points[0][1] * (points[1][2] - points[n][2]) + points[1][1] * (points[n][2] - points[0][2]) + points[n][1] * (points[0][2] - points[1][2]);
                    b = points[0][2] * (points[1][0] - points[n][0]) + points[1][2] * (points[n][0] - points[0][0]) + points[n][2] * (points[0][0] - points[1][0]);
                    c = points[0][0] * (points[1][1] - points[n][1]) + points[1][0] * (points[n][1] - points[0][1]) + points[n][0] * (points[0][1] - points[1][1]);
                    d = points[0][0] * (points[1][1] * points[n][2] - points[1][2] * points[n][1]) + points[1][0] * (points[n][1] * points[0][2] - points[0][1] * points[n][2]) + points[n][0] * (points[0][1] * points[1][2] - points[1][1] * points[0][2]);

                    if (a || b || c || d) {
                        plane = true;
                    }
                }
                else {
                    // 평면에 점이 속하는지 확인 (내적을 이용)
                    if (a * points[n][0] + b * points[n][1] + c * points[n][2] != d) {
                        possible = false;
                        break;
                    }
                }
            }

            // 결과 출력
            if (possible) {
                cout << " TAK\n";
            }
            else {
                cout << " NIE\n";
            }
        }
    }

    return 0;
}
