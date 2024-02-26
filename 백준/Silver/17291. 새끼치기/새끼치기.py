N=int(input())
arr=[0 for _ in range(21)]
arr[0]=1
arr[1]=1
for i in range(2,21):
    if i%2==0:
        arr[i]=arr[i-1]*2-arr[i-4]-arr[i-5]
    else:
        arr[i]=arr[i-1]*2
print(arr[N])
