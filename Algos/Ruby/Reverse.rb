def Reverse(arr)
    b = arr.length-1
    start=0
    while(start<b)
        temp=arr[start]        
        arr[start]=arr[b]
        arr[b]=temp
        
        start+=1
        b-=1
    end
    print arr
end

array = [1, 2, 5, 8, 7]

Reverse(array)