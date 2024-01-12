N=int(input())
dp=[0]*10000
dp[0]=1
dp[1]=1
dp[2]=2
dp[3]=3
if N==1:
    print(dp[1]%10007)
if N==2:
    print(dp[2]%10007)
if N>2:
    for i in range(3,N+1):
        dp[i]=dp[i-1]+dp[i-2]
    print(dp[N]%10007)