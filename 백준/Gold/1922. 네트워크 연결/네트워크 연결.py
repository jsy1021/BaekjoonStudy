import sys
input=sys.stdin.readline

def find(a):
    if a==parent[a]:
        return a
    parent[a]=find(parent[a])#재귀를 사용하여 루트 노드를 탐색
    return parent[a]

def union(a,b):
    a=find(a)
    b=find(b)
    
    if b<a:
        parent[a]=b
    else:
        parent[b]=a

n=int(input())
m=int(input())
arr=[]
parent=[i for i in range(n+1)]
result=0
for _ in range(m):
    a,b,c=map(int,input().split())
    arr.append([a,b,c])
arr.sort(key=lambda x:x[2])
for a,b,dis in arr:
    if find(a)!=find(b):
        union(a,b)
        result+=dis
print(result)

