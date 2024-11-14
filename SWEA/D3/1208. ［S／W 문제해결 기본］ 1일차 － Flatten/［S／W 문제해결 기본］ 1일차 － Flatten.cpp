#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int main() {
    for (int i = 1; i <= 10; i++) {
        int dumpCnt;
        cin >> dumpCnt;
        vector<int>arr(100);
        for (int j = 0; j < 100; j++) {
            cin >> arr[j];
        }
        for (int j = 0; j < dumpCnt; j++) {
            auto maxElement = max_element(arr.begin(), arr.end());
            auto minElement = min_element(arr.begin(), arr.end());
            (*maxElement)--;
            (*minElement)++;
        }
        int diff = *max_element(arr.begin(), arr.end()) - *min_element(arr.begin(), arr.end());
        cout << "#" << i << " " << diff << endl;
    }
    return 0;
}