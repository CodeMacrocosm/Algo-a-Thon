Begin
   if left < right then
      m := left + (right - left) /2
      mergeSort(array, left, m)
      mergeSort (array, m+1, right)
      merge(array, left, right)
End
