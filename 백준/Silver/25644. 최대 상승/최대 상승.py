n=int(input())
rate=list(map(int,input().split()))
#01
max_rate,res=0,0
for i in range(n-1,-1,-1):
	#02
    max_rate=max(max_rate,rate[i])
    res=max(res,max_rate-rate[i])
print(res)