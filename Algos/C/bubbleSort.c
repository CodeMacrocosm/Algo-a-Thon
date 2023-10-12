#include<stdio.h>
int main()
{
   int count, temp, i, j;
   printf("How many elments do you want to enter?: ");
   scanf("%d",&count);
   int number[count];
   printf("Enter %d elements: \n",count);
   for(i=0;i<count;i++)
   scanf("%d",&number[i]);
   // This is the main logic of bubble sort algorithm 
   for(i=count-2;i>=0;i--){
      for(j=0;j<=i;j++){
        if(number[j]>number[j+1]){
           temp=number[j];
           number[j]=number[j+1];
           number[j+1]=temp;
        }
      }
   }
   printf("Sorted elements: ");
   for(i=0;i<count;i++)
      printf(" %d",number[i]);
   return 0;
}
