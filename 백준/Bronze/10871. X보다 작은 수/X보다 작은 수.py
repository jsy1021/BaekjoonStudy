result=[]
N, X= map(int, input().split())
a=list(map(int, input().split()))
for i in range(0, N):
    if a[i]<X:
        result.append(a[i])
for i in range(len(result)):
    print("%d " %result[i], end='')