li=[]
odd=[]
for i in range(7):
    li.append(int(input()))
    if li[i]%2==1:
        odd.append(li[i])
odd=sorted(odd)
if len(odd)==0:
    print(-1)
else:
    print(sum(odd))
    print(odd[0])