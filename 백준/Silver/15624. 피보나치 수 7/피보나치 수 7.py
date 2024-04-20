import sys
input=sys.stdin.readline
MOD=1000000007
n = int(input())
 
dp= [0,1,1]
 
for i in range(3,n+1):
    dp.append((dp[i-1]+dp[i-2])%MOD)
 
print(dp[n])