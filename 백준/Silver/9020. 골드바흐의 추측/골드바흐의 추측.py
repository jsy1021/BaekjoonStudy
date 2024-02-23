import math
def d(N):
    if N==1:
        return False
    for i in range(2, int(math.sqrt(N))+1):
        if N%i==0:
            return False
    return True
T=int(input())
for _ in range(T):
    N=int(input())

    x=N//2
    y=N//2

    for _ in range(N//2):
        if d(x) and d(y):
            print(x,y)
            break
        else:
            x-=1
            y+=1
