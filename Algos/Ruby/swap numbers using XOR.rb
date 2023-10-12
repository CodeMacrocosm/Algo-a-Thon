# Ruby program to swap two numbers 
# using the Bitwise XOR (^) operator

num1=5
num2=3

print "Number before swapping:\n"
print "num1: ",num1,"\n"
print "num2: ",num2,"\n"

num1 = num1 ^ num2
num2 = num1 ^ num2
num1 = num1 ^ num2

print "\nNumber after swapping:\n"
print "num1: ",num1,"\n"
print "num2: ",num2,"\n"
