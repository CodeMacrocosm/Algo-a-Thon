//array and pointer example

#include<stdio.h>

void main()
{
    int *p, sum, i;
    int x[5] = {10,20,30,40,50};
    i = 0;
    p = x; /* initializing with base address of x */
    printf("\nElement\t\tValue\t\t Address\n");
    while(i < 5)
    {
        printf("x[%d]\t\t%d\t\t%u\n", i, *p, p);
        sum = sum + *p; /* accessing array element */
        i++, p++; /* incrementing pointer */
    }
    printf("\n Sum = %d\n", sum);
    printf("\n base address, &x[0] = %u\n", &x[0]);
    printf("\n current value of p  = %u\n", p);
}