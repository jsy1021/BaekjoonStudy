arr=[]
no=[]
for i in range(28):
    arr.append(int(input()))
    
for i in range(1,31):
    if i not in arr:
        no.append(i)
        
result=sorted(no)
print(result[0])
print(result[1])
