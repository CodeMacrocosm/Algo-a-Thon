public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {89, 45, 22, 18, 16, 15, 4, 3, 2, 0, -4, -12, -18};
        int target = 22;
        int ans = OrderAgnosticBinarySearch(arr, target);
        System.out.println(ans);
    }

    static int OrderAgnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        // find array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while (start < end){
            // find the middle element
            // int mid = (start + end)/2; might be the case that it may exceed the range of integer
            int mid = start + (end - start)/2;

            if (target == arr[mid]){
                return mid;
            }
            if (isAsc){
                if (target < arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if (target > arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
