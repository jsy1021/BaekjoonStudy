# 돌의 개수
n = int(input())

# 점프들을 담기 위한 리스트 arr
arr = [[0, 0]]
for _ in range(n - 1):
    small, big = map(int, input().split())
    arr.append([small, big])

# 큰 점프
k = int(input())

d = [0] * (n + 1)

d[0] = 0
# 돌이 한개라면
if n == 1:
    # 점프가 필요 없으므로 0 출력
    print(0)
# 돌이 2개라면
elif n == 2:
    # 1번으로 가는 작은점프 arr[1][0]출력
    print(arr[1][0])
# 돌이 3개 이상이라면
else:
    # 1까지의 최소는 1로가는 작은 점프
    d[1] = arr[1][0]
    # 2로가는 최소는
    # 1로가는 최소에서 2로가는 작은점프 d[1]+arr[2][0]
    # 바로 2로가는 큰점프 arr[1][1]
    # 2개 중 최소값
    d[2] = min(d[1] + arr[2][0], arr[1][1])

    for i in range(3, n):
        # i로 가는 최소는
        # i-1에서 작은점프로 다음돌로 이동하는 d[i-1] + arr[i][0]
        # i-2에서 큰 점프로 1개의 돌을 건너뛰어 이동하는 d[i-2] + arr[i-1][1]
        d[i] = min(d[i - 1] + arr[i][0], d[i - 2] + arr[i-1][1])
	
    # 매우 큰 점프를 사용하지 않고 n-1번째 돌로가는 최소의 에너지
    result = d[n-1]

    # 매우 큰 점프는 2칸을 건너뛰므로 3번부터 시작
    for i in range(3,n):
    	# 새로운 dp 배열 생성
        dp = d[:]
        # i번째 돌로 매우 큰 점프 하기
        dp[i] = d[i-3] + k
        
        # i+1번째 돌부터 위와 동일하게 최소를 구하기
        for j in range(i+1,n):
            dp[j] = min(dp[j - 1] + arr[j][0], dp[j - 2] + arr[j-1][1])
		
        # 매우 큰 점프를 사용한것이 더 작다면
        # result값 변환
        if result > dp[n-1]:
            result = dp[n-1]
    print(result)