#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    for (int test_case = 1; test_case <= 10; test_case++) {
        int dump;
        cin >> dump;

        // 상자 리스트 입력
        vector<int> arr_box(100);
        for (int j = 0; j < 100; j++) {
            cin >> arr_box[j];
        }

      
        for (int i = 0; i < dump; i++) {
            
            auto maxElement = max_element(arr_box.begin(), arr_box.end());
            auto minElement = min_element(arr_box.begin(), arr_box.end());

            
            (*maxElement)--;
            (*minElement)++;
        }

        // 최종 차이 계산
        int gap = *max_element(arr_box.begin(), arr_box.end()) - *min_element(arr_box.begin(), arr_box.end());

        // 결과 출력
        cout << "#" << test_case << " " << gap << endl;
    }
    return 0;
}