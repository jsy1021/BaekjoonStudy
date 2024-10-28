#include<iostream>
#include<map>
#include<string>
#include<algorithm>

using namespace std;

string Palindrome(const string& str) {
	map<char, int>freq;
	for (char ch : str) {
		freq[ch]++;
	}
	string halfStr = "";
	int oddCount = 0;// 문자열의 길이가 홀수일때는 홀수가 1번, 짝수일 때는 0번이어야 팰린드롬 가능
	char Oddchar;

	for (auto& pair : freq) {
		char ch = pair.first;
		int count = pair.second;

		if (count % 2 != 0) {
			oddCount++;
			Oddchar = ch;
		}
		halfStr += string(count / 2, ch);
	}
	if (oddCount > 1)
		return "I'm Sorry Hansoo";
	string palindrome = halfStr;
	if (oddCount == 1)
		palindrome += Oddchar;
	reverse(halfStr.begin(), halfStr.end());
	palindrome += halfStr;
	return palindrome;
}
int main() {
	string str;
	cin >> str;
	cout<<Palindrome(str);
	return 0;
}