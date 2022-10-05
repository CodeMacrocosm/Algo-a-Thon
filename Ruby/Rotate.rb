def Rotate(arr, k)
    n = arr.length
    mod = k%n
    for i in 0..n-1 do
        print arr[(n - mod + i) % n]
        print ' '
    end   
end

array = [5, 8, 12, 17, 0, 1]
a = 3

Rotate(array, a)
