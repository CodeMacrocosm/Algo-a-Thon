//Passing array to function

#include <stdio.h>

float largest(float a[], int n);

void main()
{
    float array[4] = {2.5,-4.5,1.5,3.5};
    float answer;
    answer = largest(array,4);
    printf("%f\n",answer);
}

float largest(float a[], int n)
{
    int i;
    float max;
    max = a[0];
    for(i = 1; i < n; i++)
        if(max < a[i])
            max = a[i];
    return(max);
}