N,M=map(int,input().split())
dp=[[0]*201 for _ in range(21)]
arr=[[0]*2 for _ in range(21)]
for i in range(1, M+1):
    a,b=map(int,input().split())
    arr[i][0]=a
    arr[i][1]=b

for i in range(1,M+1):
    for j in range(N+1):
        if j-arr[i][0]>=0:
            dp[i][j]=max(dp[i-1][j-arr[i][0]]+arr[i][1],dp[i-1][j])
        dp[i][j]=max(dp[i-1][j],dp[i][j])

print(dp[M][N])