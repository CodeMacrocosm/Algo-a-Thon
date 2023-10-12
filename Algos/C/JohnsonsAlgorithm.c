#include<stdio.h>
#include<conio.h>

int min(int a, int b);
int cost[10][10], a[10][10], i, j, k, c;
 
int main(int argc, char **argv) {
    int n, m;
    printf("Enter no of vertices: \n");
    scanf("%d", &n);
    printf("\nEnter no od edges: \n");
    scanf("%d", &m);
    printf("\nEnter the\nEDGE Cost\n");
    for (k = 1; k <= m; k++) {
        scanf("%d", &i);
        scanf("%d", &j);
        scanf("%d", &c);
        a[i][j] = cost[i][j] = c;
    }
    for (i = 1; i <= n; i++)
        for (j = 1; j <= n; j++) {
            if (a[i][j] == 0 && i != j)
                a[i][j] = 31999;
        }
    for (k = 1; k <= n; k++)
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                a[i][j] = min(a[i][j], a[i][k] + a[k][j]);
    printf("Resultant adjacency matrix\n");
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            if (a[i][j] != 31999)
                printf("%d ", a[i][j]);
        }
        printf("\n");
    }
    return 0;
}
int min(int a, int b) {
    if (a < b)
        return a;
    else
        return b;
}