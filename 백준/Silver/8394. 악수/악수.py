N=int(input())
arr=[0 for _ in range(N+1)]
arr[0]=1
arr[1]=1
for i in range(2,N+1):
    arr[i]=(arr[i-1]+arr[i-2])%10
print(arr[N])
