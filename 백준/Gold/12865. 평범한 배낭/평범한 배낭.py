N, K=map(int, input().split())
arr = [[0, 0]]
dp=[[0]*(K+1) for _ in range(N+1)]
for _ in range(N):
    w,v=map(int,input().split())
    arr.append([w, v])
for i in range(1,N+1):
    for j in range(1,K+1):
        w=arr[i][0]
        v=arr[i][1]
        if j<w:
            dp[i][j]=dp[i-1][j]
        else:
            dp[i][j]=max(dp[i-1][j],v+dp[i-1][j-w])
print(dp[N][K])
