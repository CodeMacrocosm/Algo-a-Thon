
class newNode:

	def __init__(self, key):
		self.data = key
		self.left = None
		self.right = None




def printSpiral(root):

	h = height(root)

	
	ltr = False
	for i in range(1, h + 1):

		printGivenLevel(root, i, ltr)

		
		ltr = not ltr





def printGivenLevel(root, level, ltr):

	if(root == None):
		return
	if(level == 1):
		print(root.data, end=" ")
	elif (level > 1):

		if(ltr):
			printGivenLevel(root.left, level - 1, ltr)
			printGivenLevel(root.right, level - 1, ltr)

		else:
			printGivenLevel(root.right, level - 1, ltr)
			printGivenLevel(root.left, level - 1, ltr)



def height(node):

	if (node == None):
		return 0
	else:

		
		lheight = height(node.left)
		rheight = height(node.right)

		
		if (lheight > rheight):
			return(lheight + 1)
		else:
			return(rheight + 1)


# Driver Code
if __name__ == '__main__':
	root = newNode(1)
	root.left = newNode(2)
	root.right = newNode(3)
	root.left.left = newNode(7)
	root.left.right = newNode(6)
	root.right.left = newNode(5)
	root.right.right = newNode(4)
	print("Spiral Order traversal of binary tree is")
	printSpiral(root)

# This code is contributed
# by SHUBHAMSINGH10
