def Josephus_iterative(n, k):
	
	k -= 1
	arr = [0]*n
	for i in range(n):
		arr[i] = 1 
	cnt = 0
	cut = 0
	num = 1
	while (cnt < (n - 1)):
	

		while (num <= k):
		
		
			cut += 1
			cut = cut % n 
			if (arr[cut] == 1):
				num+=1 
		num = 1 
		arr[cut] = 0 #
		cnt += 1 #
		cut += 1
		cut = cut % n # Ch
		while (arr[cut] == 0):
		
			cut += 1
			cut = cut % n 
			# of Index.
	
	return cut + 1 

# Driver Code
n, k = 14, 2 
print(Josephus_iterative(n, k))
