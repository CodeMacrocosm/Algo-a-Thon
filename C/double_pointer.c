//double pointer example

#include<stdio.h>

void main()
{
int x, *p1, **p2;
x = 100;
p1 = &x; /* address of x */
p2 = &p1; /* address of p1 */
printf("p1 contains adress of x which is : %u\n",p1);
printf("Address of p1 is : %u\n",&p1);
printf("p2 contains adress of p1 which is : %u\n",p2);

printf("Value of x is %d",**p2);
}