#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'fizzBuzz' function below.
#
# The function accepts INTEGER n as parameter.
#

def fizzBuzz(n):
    # Write your code here
    b = "Fizz"
    c = "Buzz"
    for i in range(1, n + 1):
        if i == 3 or i == 6 or i == 9 or i == 12:
            print(b)
        elif i == 5 or i == 10:
            print(c)
        elif i == 15:
            print("FizzBuzz")
        else:
            print(i)


if __name__ == '__main__':
    n = int(input().strip())

    fizzBuzz(n)
