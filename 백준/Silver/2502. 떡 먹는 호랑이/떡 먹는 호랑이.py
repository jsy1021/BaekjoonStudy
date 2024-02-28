D, K=map(int, input().split())
#A는 첫날의 떡의 개수, B는 둘째 날 준 떡의 개수 
for i in range(1,100000):
    for j in range(1,100000):
        dp=[0]*(D+1)
        dp[1]=i
        dp[2]=j

        for w in range(3,D+1):
            dp[w]=dp[w-1]+dp[w-2]
        if dp[-1]==K:
            print(dp[1])
            print(dp[2])
            exit()