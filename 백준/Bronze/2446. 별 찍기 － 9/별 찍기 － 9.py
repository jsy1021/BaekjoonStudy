n=int(input())
for i in range(0,n):
    print((' '*i)+'*'*(2*(n-i)-1))
for i in range(2,n+1):
    print(' '*(n-i)+'*'*(2*i-1))
