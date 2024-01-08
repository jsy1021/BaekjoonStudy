l=[1,1,2,2,2,8]
m=list(map(int, input().split()))
for i in range(len(l)):
    print(f"{l[i]-m[i]}", end=" ")