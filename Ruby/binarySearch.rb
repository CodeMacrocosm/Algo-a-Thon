def binarySearch (arr, key) 
    beg = 0
    last = arr.length-1
    
    while (beg<=last)
        mid = beg+((last-beg)/2)
        
        if arr[mid] == key
            return mid
        elsif arr[mid] < key
            beg = mid+1
        else
            last = mid-1
        end
        
    end
    
    return "Not found"
end

array = [1, 4, 6, 8, 12, 45, 78, 90]
search = 4

item = binarySearch(array, search)
print(item)