N=int(input())
lis1=list(map(int, input().split()))
M=int(input())
lis2=list(map(int, input().split()))
count={}
for card in lis1:
    if card in count:
        count[card]+=1
    else:
        count[card]=1
for target in lis2:
    result=count.get(target)
    if result== None:
        print(0, end=' ')
    else:
        print(result, end=' ')
