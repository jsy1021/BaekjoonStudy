N=int(input())
mod=9901
dp=[[0]*3 for _ in range(N)]
dp[0]=[1]*3
for i in range(1,N):
    dp[i][0]=sum(dp[i-1])%mod
    dp[i][1]=dp[i-1][0]+dp[i-1][2]%mod
    dp[i][2]=dp[i-1][0]+dp[i-1][1]%mod
print(sum(dp[N-1])%mod)