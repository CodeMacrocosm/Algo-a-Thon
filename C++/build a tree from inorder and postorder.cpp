#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    struct Node *left,*right;
};

Node* newNode(int data)
{
    Node* node = (Node*)malloc(sizeof(Node));
    node->data = data;
    node->left = node->right = NULL;
    return (node);
}
void preOrder(Node* node)
{
    if (node == NULL)
        return;
    printf("%d ", node->data);
    preOrder(node->left);
    preOrder(node->right);
}
int search(int arr[], int strt, int end, int value)
{
    int i;
    for (i = strt; i <= end; i++) {
        if (arr[i] == value)
            break;
    }
    return i;
}

Node* buildTreeUtil(int in[],int post[],int is,int ie,int ps,int pe)
{
    if(is>ie)
        return NULL;
    Node *root=newNode(post[pe]);
    if(is==ie)
        return root;
    int inPos=search(in,is,ie,post[pe]);
    root->left=buildTreeUtil(in,post,is,inPos-1,ps,ps+inPos-is-1);
    root->right=buildTreeUtil(in,post,inPos+1,ie,inPos,pe-1);
    return root;
}
Node* buildTree(int in[],int post[],int n)
{
    if(n<1)
        return NULL;
    return buildTreeUtil(in,post,0,n-1,0,n-1);
}

int main()
{
    int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
    int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
    int n = sizeof(in) / sizeof(in[0]);

    Node* root = buildTree(in, post, n);

    cout << "Preorder of the constructed tree : \n";
    preOrder(root);

    return 0;
}
