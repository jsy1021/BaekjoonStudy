#include <iostream>
#include <string>
#include <stack>
#include <unordered_map>
using namespace std;

int main() {
    for (int tc = 0; tc < 10; ++tc) {
        int T;
        string N;

        cin >> T;
        cin >> N;

        stack<char> stk;  // 여는 괄호를 쌓을 스택
        unordered_map<char, char> chk_dict = {
            {'(', ')'}, {'[', ']'}, {'{', '}'}, {'<', '>'}  // 여는 괄호와 닫는 괄호의 짝을 정의
        };

        bool ans = true;  

        
        for (char ch : N) {
            if (chk_dict.find(ch) != chk_dict.end()) {
                
                stk.push(ch);
            }
            else {
                
                if (stk.empty() || chk_dict[stk.top()] != ch) {
                    ans = false;  // 짝이 맞지 않으면 false
                    break;
                }
                stk.pop();  
            }
        }
        if (ans && stk.empty()) {
            cout << "#" << tc + 1 << " 1" << endl;
        }
        else {
            cout << "#" << tc + 1 << " 0" << endl;
        }
    }

    return 0;
}