n, s, m = map(int, input().split())
# 볼륨 리스트 입력받음
v = list(map(int, input().split()))

# dp 정의
dp = [[0] * (m+1) for i in range(n+1)]

# 처음 시작
# print(dp[0][s])
dp[0][s] = 1

for i in range(1, n+1): # 곡의 개수만큼
    for j in range(m+1): # 최대 볼륨까지 돌면서 현재 볼륨을 찾음
        if dp[i-1][j] != 0: # 볼륨 조절 가능하다면 즉 현재 볼륨 찾기
            if 0<=j+v[i-1]<=m: # 현재 볼륨과 더한 볼륨이 0 <= v <= m 이라면 더해줌
                dp[i][j+v[i-1]]=1
            if 0<=j-v[i-1]<=m: # 현재 볼륨과 뺀 볼륨이 0 <= v <= m 이라면 빼줌
                dp[i][j-v[i-1]]=1

# 볼륨 조절 불가한 경우 -1 출력을 위해 초기값 
ans = -1 
dp = dp[n]
# 최대값 찾기 위해 내림차순으로 for 문
for i in range(m, -1, -1):
    if dp[i]==1: #최대값 발견하면 중단 
        ans = i 
        break 
    # 값중 1이 하나도 없다면 가능한 볼륨이 없는 것이다.
print(ans)
