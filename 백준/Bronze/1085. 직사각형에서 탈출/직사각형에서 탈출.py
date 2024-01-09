x,y,c_x,c_y=map(int, input().split())
print(min(min(x,c_x-x),min(y,c_y-y)))