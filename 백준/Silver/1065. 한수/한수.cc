#include<iostream>

using namespace std;
int counting(int num) {
	int count;
	if (num < 100) {// 100이라면 그 자체로 한수임.
		return num;
	}
	else {//100이상의 경우만 카운팅
		count = 99;//99인 이유는 1~99까지는 모두 한수이므로 99를 기본값으로 초기화 후 100부터 누적

		for (int i = 100; i <= num; i++) {
			int hun = (i / 100);
			int ten = (i / 10) % 10;
			int one = i % 10;

			if ((hun - ten) == (ten - one)) {
				count++;
			}
		}
		
	}
	return count;
}
int main() {
	int N;
	cin >> N;
	cout<<counting(N);
	return 0;
}