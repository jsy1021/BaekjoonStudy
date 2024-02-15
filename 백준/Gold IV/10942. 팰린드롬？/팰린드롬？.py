import sys
N = int(input())

num_arr = [int(x) for x in input().split()]

M = int(input())

DP = [[0] * (N) for _ in range(N)] # DP[i][j] i부터 j까지

for i in range(N): # len == 1
    DP[i][i] = 1

for i in range(N - 1): # len == 2
    if num_arr[i] == num_arr[i + 1]:
        DP[i][i + 1] = 1

for num_len in range(2, N): # len >= 3
    for start in range(N - num_len):
        end = start + num_len
        if num_arr[start] == num_arr[end]:
            if DP[start + 1][end - 1] == 1:
                DP[start][end] = 1

for _ in range(M):
    S, E = map(int, sys.stdin.readline().split())
    print(DP[S - 1][E - 1])