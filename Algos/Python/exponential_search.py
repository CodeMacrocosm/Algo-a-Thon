def binary_search(arr, e, s, key):
    if s >= e:
        mid = e + (s - e) // 2
        if arr[mid] == key:
            return mid
        elif arr[mid] > key:
            return binary_search(arr, e, mid - 1, key)
        else:
            return binary_search(arr, mid + 1, s, key)
    else:
        return -1
def exponential_search(arr, n, key):
    if arr[0] == key:
        return 0
    i = 1
    while i < n and arr[i] <= key:
        i = i * 2
    return binary_search(arr, i // 2, min(i, n), key)

#driver code
arr = [2, 3, 4, 10, 40]
n = len(arr)
key = 10
result = exponential_search(arr, n, key)
print(result)
