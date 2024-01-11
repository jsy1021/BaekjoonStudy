n=int(input())
dic={}
for i in range(n):
    name, work=input().split()
    if work == 'enter':
        dic[name]=True
    elif work =='leave':
        del dic[name]
print("\n".join(sorted(dic.keys(), reverse=True)))
