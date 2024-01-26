N, K=map(int, input().split())
arr=[[]for _ in range(N)]
for i in range(0,N):
    for j in range(0,i+1):
        if i==0 or j==0 or j==i:
            arr[i].append(1)
        else:
            arr[i].append(arr[i-1][j-1]+arr[i-1][j])
    
print(arr[N-1][K-1])
            