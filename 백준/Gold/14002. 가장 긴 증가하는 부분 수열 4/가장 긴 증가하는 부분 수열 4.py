N=int(input())
arr=list(map(int, input().split()))
dp=[1]*(N)
for i in range(N):
    for j in range(i):
        if arr[i]>arr[j]:
            dp[i]=max(dp[i], dp[j]+1)
print(max(dp))

max_dp=max(dp)
numbers=[]
for i in range(N-1,-1,-1):
    if dp[i]==max_dp:
        numbers.append(arr[i])
        max_dp-=1

numbers.reverse()
for i in numbers:
    print(i, end=" ")