#include <bits/stdc++.h>
#include <stdlib.h>
using namespace std;

struct snode
{
    int data;
    struct snode *next;
};

struct Queue
{
    struct snode *stack1;
};
void push(struct snode **,int);
int pop(struct snode**);
void enqueue(struct Queue *q,int key)
{
    push(&q->stack1,key);
}
void push(struct snode **top,int key)
{
    struct snode *newnode=(struct snode*)malloc(sizeof(struct snode*));
    if(newnode==NULL)
    {
        printf("Stack full\n");
        return;
    }
    newnode->data=key;
    newnode->next=*top;
    *top=newnode;
    return;
}
int dequeue(struct Queue *q)
{
    if(q->stack1==NULL)
    {
        printf("Empty queue\n");
        return -1;
    }
    int res;
    if(q->stack1->next==NULL)
    {
        //q->stack1->data;
        res=pop(&q->stack1);
        return res;
    }
    //q->stack1->next;
    int x=pop(&q->stack1);
    res=dequeue(q);
    push(&q->stack1,x);
    return res;
}
int pop(struct snode **top)
{
    if(*top!=NULL)
    {
        int x=(*top)->data;
        struct snode *newtop=(*top)->next;
        free(*top);
        *top=newtop;
        return x;
    }
    return -1;
}

int main()
{
    struct Queue *q=(struct Queue*)malloc(sizeof(struct Queue));
    q->stack1=NULL;
    enqueue(q,5);
    enqueue(q,10);
    enqueue(q,15);
    printf("%d ",dequeue(q));
    printf("%d ",dequeue(q));
    printf("%d ",dequeue(q));
    return 0;
}
