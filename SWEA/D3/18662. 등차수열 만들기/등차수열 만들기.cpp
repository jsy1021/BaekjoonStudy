#include <iostream>
#include<cmath>
#include<algorithm>
using namespace std;

int main(){

	int TC;
	cin >> TC;
	for (int i = 1; i <= TC; i++) {
		int x, y, z;
		cin >> x >> y >> z;

		// 최소값 계산
		double res = min({
			abs(double(x) - (2.0 * double(y) - double(z))),
			abs(double(y) - (double(x) + double(z)) / 2.0),
			abs(double(z) - (2.0 * double(y) - double(x)))
			});
		if (res == 0.0) {
			cout << fixed;
			cout.precision(1);
			cout << "#" << i << " " << res << endl;
		}
		else {
			
			cout << "#" << i << " " << res << "\n";
		}

	}
	return 0;
}