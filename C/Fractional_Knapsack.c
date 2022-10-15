#include<stdio.h>

struct Objects
{
    int number;
    float profit;
    float weight;
    float ratio;
    float vector;
};

void knapsack(int n, float capacity, struct Objects obj_details[100])
{
    int i;
    float weight = 0, total_profit = 0;
    for(i=0; i<n; i++)
    {
        if(weight + obj_details[i].weight <= capacity)
        {
            obj_details[i].vector = 1;
            weight = weight + obj_details[i].weight;
            total_profit = total_profit + obj_details[i].profit;
        }
        else
        {
            obj_details[i].vector = (capacity - weight)/obj_details[i].weight;
            weight = capacity;
            total_profit = total_profit + obj_details[i].vector*obj_details[i].profit;
            break;
        }
    }
    printf("\n\nObject \t\tResult vector ");
    for(i=0; i<n; i++)
    {
        printf("\n%d\t\t%f",obj_details[i].number, obj_details[i].vector);
    }  
    printf("\n\nMaximum profit is: %f", total_profit);
}
void main()
{
    int n, i, j;
    float capacity;
    struct Objects obj_details[100];
    struct Objects temp;    
    printf("Enter number of objects: ");
    scanf("%d", &n);
    for(i=0; i<n; i++)
    {
        obj_details[i].number = i+1;

        printf("\nEnter profit for object %d: ", i+1);
        scanf("%f", &obj_details[i].profit);

        printf("Enter weight for object %d: ", i+1);
        scanf("%f", &obj_details[i].weight);

        obj_details[i].ratio = obj_details[i].profit/obj_details[i].weight;

        obj_details[i].vector = 0;
    }
    printf ("\nEnter the capacity of knapsack: ");
    scanf ("%f", &capacity);

    for(i=0; i<n-1; i++)
    {
        for(j=0; j<n-i-1; j++)
        {
            if(obj_details[j].ratio < obj_details[j+1].ratio)
            {
                temp = obj_details[j];
                obj_details[j] = obj_details[j+1];
                obj_details[j+1] = temp;
            }
        }
    }
    knapsack(n, capacity, obj_details);
}