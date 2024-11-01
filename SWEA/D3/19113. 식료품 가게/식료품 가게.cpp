/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// float b, c;
// double d, e, f;
// char g;
// char var[256];
// long long AB;
// cin >> a;                            // int 변수 1개 입력받는 예제
// cin >> b >> c;                       // float 변수 2개 입력받는 예제 
// cin >> d >> e >> f;                  // double 변수 3개 입력받는 예제
// cin >> g;                            // char 변수 1개 입력받는 예제
// cin >> var;                          // 문자열 1개 입력받는 예제
// cin >> AB;                           // long long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// float b = 1.0, c = 2.0;               
// double d = 3.0, e = 0.0; f = 1.0;
// char g = 'b';
// char var[256] = "ABCDEFG";
// long long AB = 12345678901234567L;
// cout << a;                           // int 변수 1개 출력하는 예제
// cout << b << " " << c;               // float 변수 2개 출력하는 예제
// cout << d << " " << e << " " << f;   // double 변수 3개 출력하는 예제
// cout << g;                           // char 변수 1개 출력하는 예제
// cout << var;                         // 문자열 1개 출력하는 예제
// cout << AB;                          // long long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int TC;
    cin >> TC;

    for (int i = 1; i <= TC; i++) {
        int N;
        cin >> N;
        vector<long> P(2 * N);

        for (int j = 0; j < 2 * N; j++) {
            cin >> P[j];
        }

        cout << "#" << i << " ";

        for (int n = 0; n < N; n++) {
            // 첫 번째 요소의 정상 가격에 해당하는 값(4의 배수)을 찾음
            long normalPrice = P[0] * 4 / 3;
            // 해당 정상 가격 위치를 찾아 제거
            auto it = find(P.begin(), P.end(), normalPrice);
            if (it != P.end()) {
                P.erase(it);  // 정상 가격 제거
            }

            // 할인가를 출력 및 제거
            if (n == N - 1) {
                cout << P[0] << endl;
            }
            else {
                cout << P[0] << " ";
            }
            P.erase(P.begin());  // 현재 첫 번째 할인가를 제거
        }
    }

    return 0;
}