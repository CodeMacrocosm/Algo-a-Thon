#include <stdio.h>

void main()
{
    int i,j,k;
    for(i=1; i<=5; i++) { for(j=4; j>=i; j--)
        {
            printf(" ");
        }
        for(k=1; k<=(2*i-1); k++)
        {
            printf("*");
        }
        printf("\n");
    }
}
