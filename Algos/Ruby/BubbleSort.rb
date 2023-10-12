def bubbleSort(arr)
    n=arr.length
    for i in 0...n-1
     for j in 0...n-i-1
         if arr[j]>arr[j+1]
             temp=arr[j]
             arr[j]=arr[j+1]
             arr[j+1]=temp
         end
     end
    end
    return arr
end

array = [1,4, 6, 11, 6, 2, 78, 32, 88, 21]
sorted = bubbleSort(array)
print(sorted)