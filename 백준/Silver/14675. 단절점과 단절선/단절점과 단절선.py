import sys
input=sys.stdin.readline

N=int(input())
Tree=[ [] for _ in range(N+1) ]

for i in range(N-1):
    a,b=map(int,input().split())
    Tree[a].append(b)
    Tree[b].append(a)

Q=int(input())

for i in range(Q):
    a,b=map(int,input().split())

    if a==2:
        print("yes")
    else:
        if len(Tree[b])>=2:
            print("yes")
        else:
            print("no")
        