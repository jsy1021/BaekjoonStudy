N=int(input())
arr=[0]
dp=[0]*(N+1)
for _ in range(N):
    arr.append(float(input()))
dp[1]=arr[1]
for i in range(2,N+1):
    dp[i]=max(dp[i-1]*arr[i],arr[i])

print('{:.3f}'.format(max(dp)))