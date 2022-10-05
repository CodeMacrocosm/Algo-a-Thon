// functin returning pointer

#include<stdio.h>
int *larger(int *, int *); /* prototype */
void main ( )
{
    int a = 10;
    int b = 20;
    int *p;
    p = larger(&a,&b); //Function call 
    printf ("larger is %d", *p);
}
int *larger (int *x, int *y)
{
    if (*x>*y)
        return (x); /*address of a */
    else
        return (y); /* address of b */
}