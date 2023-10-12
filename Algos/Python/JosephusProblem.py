def JosephusProblem(n , k):
    if n==1:
        return 1
    else:
        return (JosephusProblem(n-1 , k) + k-1) % n +1

print("JosephusProblem(8,2) = " , end=' ')
print(JosephusProblem(8,2))
print("JosephusProblem(7,3) = " , end=' ')
print(JosephusProblem(7,3))