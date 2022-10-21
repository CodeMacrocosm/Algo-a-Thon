def GCD_Loop( a, b):  
    if a > b:  # define the if condition  
        temp = b  
    else:  
        temp = a  
    for i in range(1, temp + 1):  
        if (( a % i == 0) and (b % i == 0 )):  
            gcd = i  
    return gcd 
