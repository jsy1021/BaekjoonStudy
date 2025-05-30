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
#include<vector>
#include<string>
using namespace std;

int main() {
	int TC;
	cin >> TC;
	for (int i = 1; i <= TC; i++) {
		string ans = "yes";
		vector<vector<char>>arr;
		int rookCount = 0;
		for (int j = 0; j < 8; j++) {
			
			string str;
			cin >> str;
			vector<char>s(str.begin(), str.end());
			arr.push_back(s);
			for (int k = 0; k < 8; k++) {
				if (arr[j][k] == 'O')
					rookCount++;
			}
		}

		//행의 수
		for (int j = 0; j < 8; j++) {
			int rowCount = 0;
			for (int k = 0; k < 8; k++) {
				if (arr[j][k] == 'O')
					rowCount++;
			}
			if (rowCount > 1) {
				ans = "no";
				break;
			}
		}

		//열의 수
		for (int j = 0; j < 8; j++) {
			int colCount = 0;
			for (int k = 0; k < 8; k++) {
				if (arr[k][j] == 'O') {
					colCount++;
				}
			}
			if (colCount > 1) {
				ans = "no";
				break;
			}
		}
		if (rookCount != 8) {
			ans = "no";
		}
		cout << "#" << i << " "<<ans<<endl;
		
	
	}
	return 0;
}