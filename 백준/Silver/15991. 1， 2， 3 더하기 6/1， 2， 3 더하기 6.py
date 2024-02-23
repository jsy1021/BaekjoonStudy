
mod=1000000009
dp=[0,1,2,2,3,3,6]
for i in range(7,100002):
    dp.append((dp[i-2]+dp[i-4]+dp[i-6])%mod)
for _ in range(int(input())):
    N=int(input())
    print(dp[N])