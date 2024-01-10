inn=[]
out=[]
now=0
max_num=0
for i in range(4):
    x,y=map(int, input().split())
    out.append(x)
    inn.append(y)

for i in range(4):
    now-=out[i]
    now+=inn[i]
    max_num=max(max_num,now)
print(max_num)