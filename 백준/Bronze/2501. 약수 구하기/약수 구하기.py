N, K=map(int, input().split())
arr=list()
for i in range(1, N+1):
    if N%i==0:
        arr.append(i)

arr.sort()
if(len(arr)<K):
    print(0)
else:
    print(arr[K-1])