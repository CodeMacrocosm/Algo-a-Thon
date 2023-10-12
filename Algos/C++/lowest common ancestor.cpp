#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int key;
    struct Node *left, *right;
};
Node * newNode(int k)
{
    Node *temp = new Node;
    temp->key = k;
    temp->left = temp->right = NULL;
    return temp;
}
bool path(Node *root, vector<int> *p,int key)
{
    if(!root)
        return false;
    (*p).push_back(root->key);
    if(root->key==key)
        return true;
    if(path(root->left,p,key)||path(root->right,p,key))
        return true;
    (*p).pop_back();
    return false;
}
int findLCA(Node *root,int n1,int n2)
{
    vector<int> path1,path2;
    int i;
    if((!path(root,&path1,n1))||(!path(root,&path2,n2)))
        return -1;
    for(i=0;i<path1.size() && i<path2.size();i++)
    {
        if(path1[i]!=path2[i])
            break;
    }
    return path1[i-1];
}
int main()
{
    // Let us create the Binary Tree shown in above diagram.
    Node * root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(6);
    root->right->right = newNode(7);
    cout << "LCA(4, 5) = " << findLCA(root, 4, 5)<<endl;
    cout << "nLCA(4, 6) = " << findLCA(root, 4, 6)<<endl;
    cout << "nLCA(3, 4) = " << findLCA(root, 3, 4)<<endl;
    cout << "nLCA(2, 4) = " << findLCA(root, 2, 4)<<endl;
    return 0;
}
