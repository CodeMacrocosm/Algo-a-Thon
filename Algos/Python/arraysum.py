n = int(input())
ar = list(map(int,input().split()))
ans = 0
for i in range(n):
    ans = ans + ar[i]
print(ans)
