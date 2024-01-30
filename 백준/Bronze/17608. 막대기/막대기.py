import sys
input = sys.stdin.readline

N=int(input())
arr=[]
for _ in range(N):
    arr.append(int(input()))
count=0
max=0
for i in range(N):
    item=arr.pop()
    if max<item:
        max=item
        count+=1
print(count)