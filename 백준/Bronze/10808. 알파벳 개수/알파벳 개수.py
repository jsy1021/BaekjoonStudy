import sys
s=sys.stdin.readline().rstrip()
dic={}
for chr in 'abcdefghijklmnopqrstuvwxyz':
    dic[chr]=0
for chr in s:
    if chr in dic:
        dic[chr]+=1
    else:
        dic[chr]=1
for i in dic:
    print(dic.get(i),end=" ")