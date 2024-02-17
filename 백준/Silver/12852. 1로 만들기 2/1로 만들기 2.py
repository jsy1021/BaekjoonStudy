n=int(input())

res=[[0,[]] for _ in range(n+1)]
res[1][0]=0
res[1][1]=[1]

for i in range(2,n+1):
    res[i][0]=res[i-1][0]+1
    res[i][1]=res[i-1][1]+[i]
    
    if i%3==0 and res[i//3][0]+1<res[i][0]:
        res[i][0]=res[i//3][0]+1
        res[i][1]=res[i//3][1]+[i]
    if i%2==0 and res[i//2][0]+1<res[i][0]:
        res[i][0]=res[i//2][0]+1
        res[i][1]=res[i//2][1]+[i]
print(res[n][0])
for i in res[n][1][::-1]:
    print(i, end = " ")