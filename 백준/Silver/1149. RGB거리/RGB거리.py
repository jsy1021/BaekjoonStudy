#백준 1149
N=int(input())
RGB=[]
dp=[]
for i in range(N):
    RGB.append(list(map(int, input().split())))
for i in range(1,N):
    RGB[i][0]=min(RGB[i-1][1],RGB[i-1][2])+RGB[i][0]
    RGB[i][1]=min(RGB[i-1][0],RGB[i-1][2])+RGB[i][1]
    RGB[i][2]=min(RGB[i-1][0],RGB[i-1][1])+RGB[i][2]
print(min(RGB[N-1][0],RGB[N-1][1],RGB[N-1][2]))
