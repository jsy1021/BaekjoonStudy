N=int(input())
P=list(map(int, input().split()))
S=[0]*N

#삽입정렬
for i in range(1, N):
    for j in range(i, 0, -1):
        if P[j-1]>P[j]:
            P[j-1],P[j]=P[j],P[j-1]
        else:
            break
S[0]=P[0]
for i in range(1,N):
    S[i]=S[i-1]+P[i]
sum=0
for i in range(0, N):
    sum+=S[i]
    
print(sum)