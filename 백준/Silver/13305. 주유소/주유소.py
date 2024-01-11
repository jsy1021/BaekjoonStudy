N=int(input())
dis=list(map(int, input().split()))
cost=list(map(int, input().split()))
result=0
c=cost[0]
for i in range(N-1):
    if c>cost[i]:
        c=cost[i]
    result+=c*dis[i]
print(result)