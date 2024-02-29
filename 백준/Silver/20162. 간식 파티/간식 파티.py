N=int(input())
arr=[0]*(N+1)
dp=[0]*(N+1)
for i in range(1,N+1):
    arr[i]=int(input())

for i in range(1,N+1):
    for j in range(i+1):
        if arr[i]>arr[j] and dp[j]+arr[i]>dp[i]:
            dp[i]=dp[j]+arr[i]
print(max(dp))