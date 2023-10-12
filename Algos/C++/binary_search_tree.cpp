#include <iostream>
using namespace std;

struct node {
    int key;
    struct node* left, * right;
};

class bst
{
public:

    struct node* newNode(int item) {
        node* temp = new node;
        temp->key = item;
        temp->left = temp->right = NULL;
        return temp;
    }
    void inorder(node* root) {
        if (root != NULL) {
            inorder(root->left);
            cout << root->key << " -> ";
            inorder(root->right);
        }
    }


     node* insert(node* node, int key) {
        if (node == NULL) 
            return newNode(key);
        if (key < node->key)
            node->left = insert(node->left, key);
        else
            node->right = insert(node->right, key);

        return node;
    }
};

int main() {
    bst x;
    node* root = NULL;
    root = x.insert(root, 8);
    root = x.insert(root, 3);
    root = x.insert(root, 1);
    root = x.insert(root, 6);
    root = x.insert(root, 7);
    root = x.insert(root, 10);
    root = x.insert(root, 14);
    root = x.insert(root, 4);
    root = x.insert(root, 23);

    cout << "Inorder traversal: ";
    x.inorder(root);
    return 0;
}