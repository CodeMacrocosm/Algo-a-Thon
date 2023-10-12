#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node *left, *right;
};

vector<int> el;

void leftBoundary(Node *root)
{
    if(!root)
        return;
    if(find(el.begin(),el.end(),root->data)==el.end())
        el.push_back(root->data);
    if(root->left)
        leftBoundary(root->left);
    else
        leftBoundary(root->right);
}

void leafNodes(Node *root)
{
    if(!root)
        return;
    if(!root->left && !root->right)
        if(find(el.begin(),el.end(),root->data)==el.end())
            el.push_back(root->data);
    leafNodes(root->left);
    leafNodes(root->right);
}

void rightBoundary(Node *root)
{
    if(!root)
        return;
    if(root->right)
        rightBoundary(root->right);
    else
        rightBoundary(root->left);
    if(find(el.begin(),el.end(),root->data)==el.end())
        el.push_back(root->data);
}

void printBoundary(Node *root)
{
    if(!root)
        return;
    leftBoundary(root);
    leafNodes(root);
    rightBoundary(root);
    int i;
    for(i=0;i<el.size();i++)
        cout<<el[i]<<" ";
    cout<<endl;
}

Node* newNode(int data)
{
    Node* temp = (Node*)malloc(sizeof(Node));

    temp->data = data;
    temp->left = temp->right = NULL;

    return temp;
}

int main()
{
    // Let us construct the tree given in the above diagram
    struct Node* root = newNode(20);
    root->left = newNode(8);
    root->left->left = newNode(4);
    root->left->right = newNode(12);
    root->left->right->left = newNode(10);
    root->left->right->right = newNode(14);
    root->right = newNode(22);
    root->right->right = newNode(25);

    printBoundary(root);

    return 0;
}
