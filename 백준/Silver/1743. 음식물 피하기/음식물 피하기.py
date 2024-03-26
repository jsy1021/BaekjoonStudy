import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

def DFS(y, x):
    global field, dy, dx, N, M, comp
    
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if 0 <= ny < N and 0 <= nx < M and field[ny][nx]:
            field[ny][nx] = 0
            comp += 1
            DFS(ny, nx)

N, M, K = map(int, input().split())
field = [[0 for i in range(M)] for j in range(N)]
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

for _ in range(K):
    r, c = map(int, input().split())
    field[r-1][c-1] = 1

size = -1
for i in range(N):
    for j in range(M):
        if field[i][j]:
            field[i][j] = 0
            comp = 1
            DFS(i, j)
            size = max(comp, size)

print(size)