# A py program to find the power set

from typing import List


def powSet( li:List ) :
    result = []
    for i in range( 0 , 2**len(li) ):
        temp = []
        for j in range( 0 , len(li) ):
            if (i & ( 1<<j )) > 0 :
                temp.append( li[j] )
        result.append(temp)
    return result

if __name__ == '__main__':
    li=list(input("Enter the elements of the list : \n").split())
    print(powSet(li))