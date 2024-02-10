N, K=map(int ,input().split())
dp=[10001]*(K+1)
dp[0]=0
nums=[]
for _ in range(N):
    nums.append(int(input()))

for num in nums:
    for i in range(num,K+1):
        dp[i]=min(dp[i],dp[i-num]+1)

if dp[K]==10001:
    print(-1)
else:
    print(dp[K])