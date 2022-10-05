//Recursion example

#include <stdio.h>

int factorial(int n)
{
  int fact;
  if (n==1)
    return(1);
  else
    fact = n*factorial(n-1);
  return(fact);
}

void main()
{
    int n=5, f;
    
    f=factorial(n);
    
    printf("factorial of %d is %d", n,f);
    
}