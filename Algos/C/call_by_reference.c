// Call by reference example

#include <stdio.h>

void mathoperations(int x, int y, int *s, int *d);
void main()
{
    int x=20, y=10, s, d;  // x and y input arguments, s and d output arguments
    mathoperations(x, y, &s, &d);
    printf("  s=%d\n  d=%d\n", s,d);
}


void mathoperations(int a, int b, int *sum, int *diff)  // x to a, y to b, address of s to sum and address of d to diff
{
    *sum=a+b;   //sum and diff are pointer variables
    *diff=a-b;  //*sum and *diff are pointers
}