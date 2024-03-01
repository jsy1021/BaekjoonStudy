N=int(input())
MOD=1000000000
arr=[0, 1]
for i in range(2, abs(N)+1):
    arr.append((arr[i-1]+arr[i-2])%MOD)
if N%2==0 and N<0:
    print(-1)
elif N==0:
    print(0)
else:
    print(1)
print(arr[abs(N)])