 public void sort(int arr[])
    {
        int n = arr.length;
  
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
  
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
  
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
 }
