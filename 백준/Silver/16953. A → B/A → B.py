import sys
input=sys.stdin.readline
a,b=map(int,input().split())
count=1
while True:
    if b==a:
        break
    elif (b%2!=0 and b%10!=1)or (b<a):
        count=-1
        break
    else:
        if b%10==1:
            b//=10
            count+=1
        else:
            b//=2
            count+=1
print(count)
    