n,m = map(int,input().split())
arr = list(input() for _ in range(n))
d = [[0]*m for _ in range(n)]
ans = 0
for i in range(n):
    for j in range(m):
        if i==0 or j==0:
            d[i][j] = int(arr[i][j])
        elif arr[i][j]=="0":
            d[i][j] = 0
        else:
            d[i][j] = min(d[i-1][j-1], d[i-1][j], d[i][j-1])+1
        ans = max(d[i][j], ans)
print(pow(ans,2))