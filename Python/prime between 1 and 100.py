'''
This is a program to print prime numbers between 1 to 100

'''

def IsPrime(n : int):
    for i in range(2,int(n/2)):
        if n%i ==0 :
            return False
    else:
        return True


for i in range(2,101):
    if IsPrime(i) :
        print(i, end = ", ")
