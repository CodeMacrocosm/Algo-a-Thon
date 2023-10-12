def PascalTriangle(rows)
    res = []
    for i in 1..rows do
        arr = []
        arr[0] = 1
        arr[i-1] = 1

        if i == 1 || i == 2
            res << arr
            next 
        end

        for j in 1..i-2 do
            arr[j] = res[i-2][j-1] + res[i-2][j]
        end
        res << arr  
    end
    return res
end

print PascalTriangle(8)