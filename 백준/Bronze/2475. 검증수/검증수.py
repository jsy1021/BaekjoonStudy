l=list(map(int, input().split()))
sum=0
for i in range(len(l)):
    sum+=pow(l[i],2)

print(sum%10)