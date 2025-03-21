import sys
from collections import deque
N = int(input())

dx = [-1,0,0,1] # 상 좌 우 하
dy = [0,-1,1,0]
room = []
sharksize = 2
sharkeat = 0

for i in range(N):
    room.append([int(x) for x in sys.stdin.readline().rstrip().split()])
    for j in range(len(room[i])):
        if room[i][j] == 9:
            room[i][j] = 0
            shark_x, shark_y = i, j

def finding_fish(sx,sy):
    global sharksize
    deq = deque()
    deq.append([sx,sy])

    visited = [[False for _ in range(N)] for _ in range(N)]
    distance = [[0 for _ in range(N)] for _ in range(N)]
    can_eat_fish = []

    while deq:
        x, y = deq.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if room[nx][ny] <= sharksize and not visited[nx][ny]: #이동이 가능하면
                    visited[nx][ny] = True
                    distance[nx][ny] = distance[x][y] + 1
                    deq.append([nx,ny])

                    if room[nx][ny] < sharksize and room[nx][ny] != 0: #물고기가 있고 그걸 먹을 수 있다면
                        can_eat_fish.append([nx ,ny,distance[nx][ny]])

    can_eat_fish.sort(key= lambda x : (x[2],x[0],x[1])) # 정렬은 거리, x, y 오름차순으로
    return can_eat_fish

if __name__ == '__main__':
    ans = 0

    while True:
        fishlist = finding_fish(shark_x,shark_y)

        if len(fishlist) == 0: # 먹을 수 있는 물고기가 없다면
            print(ans)
            exit(0)

        shark_x, shark_y, move_time = fishlist[0]

        sharkeat += 1
        if sharksize == sharkeat: #먹은 물고기수와 사이즈가 같다면
            sharkeat = 0
            sharksize += 1

        room[shark_x][shark_y] = 0 # 물고기 먹은 자리는 빈칸으로 바꿈
        ans += move_time