//sizeof() an union example

#include<stdio.h>
void main()
{
    int a;
    float b;
    struct student_details
    {
        char name[20];
        int regno;
    }student;
    
    union code
    {
        int x;
        char c;
        float y;
    }sample;
    
    printf("size of variable a=%d\n",sizeof(a));
    printf("size of variable b=%d\n",sizeof(b));
    printf("size of structure variable is %d\n",sizeof(student));
    printf("size of union variable is %d\n",sizeof(sample));
    printf("size of integer is %d\n",sizeof(int));
    
}