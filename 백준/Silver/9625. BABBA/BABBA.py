K=int(input())
arr=[0]*(K+1)
arr[1]=1
for i in range(2,K+1):
    arr[i]=arr[i-1]+arr[i-2]
print(arr[K-1], arr[K])