#백준 1015번
N=int(input())
arr=list(map(int, input().split()))
sorted_arr=sorted(arr)

P=[]
for i in range(N):
    P.append(sorted_arr.index(arr[i]))
    sorted_arr[sorted_arr.index(arr[i])]=-1
    
for i in range(N):
    print(str(P[i]), end=' ')
