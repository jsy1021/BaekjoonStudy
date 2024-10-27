#include<iostream>

using namespace std;
int main() {
	int input;
	cin >> input;
	int round = 10;
	while (input >= round) {
		input = (input + round / 2) / round * round;
		round *= 10;
	}
	cout << input << endl;
	return 0;
}