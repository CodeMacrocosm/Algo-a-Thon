def selection_sort(arr):
    for i in range(len(arr)):
        min_index = i
        for j in range(i+1, len(arr)):
            if arr[min_index] > arr[j]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]
#driver code
arr = [64, 25, 12, 22, 11]
selection_sort(arr)
print ("Sorted array")
for i in range(len(arr)):
    print("%d" %arr[i])
    