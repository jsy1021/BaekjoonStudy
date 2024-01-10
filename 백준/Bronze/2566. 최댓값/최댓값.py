x=[]
max_num=0
location_x=0
location_y=0
for i in range(9):
    x.append(list(map(int, input().split())))
for i in range(9):
    for j in range(9):
        if(max_num<x[i][j]):
            max_num=x[i][j]
            location_x=i
            location_y=j
print(max_num)
print(f"{location_x+1} {location_y+1}")
