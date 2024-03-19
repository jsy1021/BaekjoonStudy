import sys
input=sys.stdin.readline

N, M=map(int,input().split())
arr=list(map(int,input().split()))
for i in range(N-1):
    arr[i+1]+=arr[i]
arr=[0]+arr
for _ in range(M):
    start, end=map(int,input().split())
    print(arr[end]-arr[start-1])