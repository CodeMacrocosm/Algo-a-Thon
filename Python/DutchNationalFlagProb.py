def dutch_sort(a, arr_size):
    low = 0
    high = arr_size - 1
    mid = 0
    # Iterate till all the elements are sorted
    while mid <= high:
        # If the element is 0
        if a[mid] == 0:
            a[low], a[mid] = a[mid], a[low]
            low = low + 1
            mid = mid + 1
        # If the element is 1
        elif a[mid] == 1:
            mid = mid + 1
        # If the element is 2
        else:
            a[mid], a[high] = a[high], a[mid]
            high = high - 1
    return a
 
# Function to print array
 
 
def printArray(a):
    for k in a:
        print(k, end=' ')
 
 
arr = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 1]
arr_size = len(arr)
arr = dutch_sort(arr, arr_size)
printArray(arr)
