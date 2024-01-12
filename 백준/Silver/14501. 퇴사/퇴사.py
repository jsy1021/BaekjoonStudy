#백준 14501
def dfs(n, sum):
    global ans
    if n>=N:
        ans=max(ans,sum)
        return
    
    if n+T[n]<=N:
        dfs(n+T[n], sum+P[n])
    dfs(n+1,sum)
N=int(input())
T=[0]*N
P=[0]*N
for i in range(N):
    T[i], P[i]=map(int, input().split())
ans=0
dfs(0,0)
print(ans)