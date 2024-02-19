s=list(map(int,input()))
l=len(s)
dp=[0]*(l+1)
dp[0]=1
dp[1]=1

if s[0]==0:
    print(0)
else:
    for i in range(1,l):
        j=i+1
        if s[i]>0:
            dp[j]+=dp[j-1]
        if 10<=s[i]+s[i-1]*10<=26:
            dp[j]+=dp[j-2]
    print(dp[l]%1000000)

