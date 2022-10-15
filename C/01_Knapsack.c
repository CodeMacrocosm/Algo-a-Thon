#include<stdio.h>
int maxOf(int item1, int item2)
{
    return (item1>item2) ? item1: item2;
}
int knapsack(int W, int weights[100], int profits[100],int n)
{
    int table[n+1][W+1], i, j, temp, itemsIncluded[100];
	for(i=0; i<=n; i++)
	{
		table[i][0] = 0;
	}
	for(j=0; j<=W; j++)
	{
		table[0][j] = 0;
	}

	for(j=1; j<=W; j++)
	{
		for(i=1; i<=n; i++)
		{
			if(weights[i] <= W)
			{
				if(j - weights[i] < 0)
				{
					table[i][j] = table[i-1][j];
				}
				else
				{
					table[i][j] = maxOf(table[i-1][j], profits[i] + table[i-1][j - weights[i]]);
				}
			}
			else
			{
				table[i][j] = table[i-1][j];
			}
		}		
	}
	printf("The table made usng dynamic programmig is:\n");
	for(i=0; i<=n; i++)
	{
		for(j=0; j<=W; j++)
		{
			printf("%d\t",table[i][j]);
		}
		printf("\n");
	}

	i = n;
	j = W;
	temp = 1;

	while(i>0)
	{
		if(table[i][j]!=table[i-1][j])
		{
			itemsIncluded[temp] = i;
			temp++;
			j = j - weights[i];
			i--;
		}
		else
		{
			i--;
		}
	}

	printf("\nItems included are : ");
	for(i=temp-1; i>=1; i--)
	{
		printf("%d   ",itemsIncluded[i]);
	}

	return table[n][W];
}
void main()
{
    int n, maxProfit, profits[100], weights[100], W, i;
    printf("Enter the number of items: ");
    scanf("%d", &n);
    for(i=1; i<=n; i++)
    {
        printf("\n\n");
		printf("Enter weight of item %d: ",i);
        scanf("%d", &weights[i]);
		printf("Enter profit of item %d: ",i);
		scanf("%d", &profits[i]);
    }
    printf("Enter weight of knapsack: ");
    scanf("%d", &W);
    maxProfit = knapsack(W,weights,profits,n);
	printf("\n\nMaximum Profit is %d",maxProfit);
}