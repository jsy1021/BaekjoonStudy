s=[]
def dfs(x):
    if len(s)==M:
        print(*s)
        return
    for i in range(x, N+1):
        s.append(i)
        dfs(i)
        s.pop()

N, M=map(int, input().split())
dfs(1)