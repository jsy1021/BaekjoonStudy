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

#include<iostream>
#include<algorithm>
using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        // 첫 번째, 두 번째, 세 번째 사각형의 좌표들
        int x1, y1, x2, y2;  // 첫 번째 사각형
        int x3, y3, x4, y4;  // 두 번째 사각형
        int x5, y5, x6, y6;  // 세 번째 사각형
        bool result = true;   // 기본적으로 "YES"로 설정

        // 각 사각형의 좌표 입력
        cin >> x1 >> y1 >> x2 >> y2;  // 첫 번째 사각형
        cin >> x3 >> y3 >> x4 >> y4;  // 두 번째 사각형
        cin >> x5 >> y5 >> x6 >> y6;  // 세 번째 사각형

        // 두 번째 사각형이 첫 번째 사각형을 완전히 덮는지 확인
        if (x3 <= x1 && x4 >= x2 && y3 <= y1 && y4 >= y2) result = false;

        // 세 번째 사각형이 첫 번째 사각형을 완전히 덮는지 확인
        if (x5 <= x1 && x6 >= x2 && y5 <= y1 && y6 >= y2) result = false;

        // 두 번째와 세 번째 사각형이 첫 번째 사각형을 동시에 덮는 경우를 처리
        if (x3 <= x1 && x5 <= x1 && x4 >= x2 && x6 >= x2) {
            // 두 번째와 세 번째 사각형이 각각 가로로 덮는 경우
            if (min(y3, y5) <= y1 && max(y4, y6) >= y2 && ((y5 <= y4) && (y3 <= y6))) result = false;
        }

        if (y3 <= y1 && y5 <= y1 && y4 >= y2 && y6 >= y2) {
            // 두 번째와 세 번째 사각형이 각각 세로로 덮는 경우
            if (min(x3, x5) <= x1 && max(x4, x6) >= x2 && ((x5 <= x4) && (x3 <= x6))) result = false;
        }

        // 결과 출력
        cout << (result ? "YES" : "NO") << '\n';
    }
    return 0;
}