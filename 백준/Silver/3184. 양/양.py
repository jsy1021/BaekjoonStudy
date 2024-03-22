import sys
sys.setrecursionlimit(10 ** 6)
r, c = map(int, input().split())
garden = [list(input()) for _ in range(r)]
visited = [[0] * c for _ in range(r)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
sheep = 0
wolves = 0
a,b=0,0
def in_range(x, y):
    return 0 <= x < r and 0 <= y < c
def dfs(x, y):
    global a, b
    #visited[x][y] = True
    if in_range(x, y):
        if garden[x][y] != '#' and visited[x][y] == 0:
            visited[x][y] = True
            if garden[x][y] == 'o':
                a += 1
            if garden[x][y] == 'v':
                b += 1
            for i in range(4):
                nx = dx[i] + x
                ny = dy[i] + y
                dfs(nx, ny)
            return True
        return False

for i in range(r):
    for j in range(c):
        a, b = 0, 0
        if dfs(i, j) == True:
            if a > b:
                sheep += a
            else:
                wolves += b
print(sheep, wolves)