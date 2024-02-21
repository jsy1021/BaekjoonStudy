N=int(input())
max_index=1000
dp=[False]*(max_index+1)
dp[1]=True
dp[3]=True
dp[4]=True
for i in range(5, N+1):
    if dp[i-1] and dp[i-3] and dp[i-4]:
        dp[i]=False
    else:
        dp[i]=True
if dp[N]==True:
    print("SK")
else:
    print("CY")