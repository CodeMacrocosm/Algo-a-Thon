// Josephus Algorithm in C++
#include<iostream>
#include<malloc.h>

using namespace std;
/*
    One liner Code for Josephus Algorith
    int josephus(int N, int K) {
    if (N == 1)
        return 1;
    else
        return (josephus(N - 1, K) + K - 1) % N + 1;
    }
*/

struct node{
    int player_no;
    struct node *next;
};

struct node *start , *ptr , *new_node;

int main(void)
{
    int n , k=3;
    cout <<"Enter number of player : ";
    cin >> n;
    start = malloc(sizeof(struct node));
    start->player_no = 1;

    for(int i=2; i<=n; i++)
    {
        new_node = malloc(sizeof(struct node));
        ptr->next =new_node;
        new_node->player_no=i;
        new_node->next = start;
        ptr = new_node;
    }

    for(int count=n ; count>1;count--)
    {
        for(int i=0 ; i<k-1 ; i++)
        {
            ptr = ptr->next;
            cout << "Delete : " << ptr->next->player_no;
            ptr->next = ptr->next->next;
        }
    }
    cout << "surviver : "<<ptr->player_no;
}