#include<iostream>
#include <cstring>
using namespace std;
struct node
{
	int data;
	node* llink;
	node* rlink;
};
class tree
{
public:
	node* insert( int info, node* root) {
		char direction[10];
		int i;
		node* temp = new node;
		node* curr = new node;
		node* prev = new node;
		temp->data = info;
		temp->llink = temp->rlink = NULL;
		if (root==NULL)
		{
			return temp;
		}
		cout << "Give Directions" << endl;
		cin >> direction;
		prev = NULL;
		curr = root;
		for ( i = 0; i < strlen(direction)&&(curr!=NULL); i++)
		{
			prev = curr;
			if (direction[i]=='L')
			{
				curr = curr->llink;
			}
			else
			{
				curr = curr->rlink;
			}
			
		}
		int x = i - 1;
		if (direction[x] == 'L')
		{
			prev->llink = temp;
		}
		else
		{
			prev->rlink = temp;
		}
		return root;

	}
	void preorderTraversal(struct node* node) {
		if (node == NULL)
			return;

		cout << node->data << "->";
		preorderTraversal(node->llink);
		preorderTraversal(node->rlink);
	}
	void inorder(node* node) {
		if (node==NULL)
		{
			return;
		}
		inorder(node->llink);
		cout << node->data << "->";
		inorder(node->rlink);

	}
	void postorder(node* node) {
		if (node == NULL)
		{
			return;
		}
		inorder(node->llink);
		inorder(node->rlink);
		cout << node->data << "->";

	}
};
int main() {
	tree obj;
	node* root = NULL;
	root = obj.insert(1, root);
	root = obj.insert(2, root);
	root = obj.insert(3, root);
	root = obj.insert(4, root);
	root = obj.insert(5, root);
	obj.preorderTraversal(root);
	cout << endl;
	obj.inorder(root);
	cout << endl;
	obj.postorder(root);
}
//Directions to be given in capital letters and L for left and R for right
//Example: LLR for left left right