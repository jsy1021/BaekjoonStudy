#include <iostream>

using namespace std;

int N, M;
int arr[7];
int dfs(int count)
{
	if (count == M)
	{
		//count가 M에 도달했을 때 조건없이 출력
		for (int i = 0; i < M; i++)
		{
			cout << arr[i] << ' ';
		}
		return 0;
	}
	for (int i = 0; i < N; i++)
	{
		//숫자 중복이 가능하므로 bool형 배열을 사용하지 않는다.
		arr[count] = i + 1;
		dfs(count + 1);
	}
	return 0;
}

int main()
{
	cin >> N >> M;
	dfs(0);
}