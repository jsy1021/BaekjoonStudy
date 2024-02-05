import sys

N = int(sys.stdin.readline().strip())

mmin = [0,0,0]
mmax = [0,0,0]
for _ in range(N):
    cur = list(map(int, sys.stdin.readline().split()))
    mmin = [cur[0] + min(mmin[:2]) , cur[1] + min(mmin), cur[2] + min(mmin[1:])]
    mmax = [cur[0] + max(mmax[:2]) , cur[1] + max(mmax), cur[2] + max(mmax[1:])]

print(max(mmax),min(mmin))