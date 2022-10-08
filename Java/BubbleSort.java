public class BubbleSort {

    public static void printarr(int arr[], int size) {
        for (int i = 0; i < size; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String args[]) {
        int arr[] = { 5, 4, 3, 2, 1 };
        int n = arr.length;
        System.out.println("Before sorting: ");
        printarr(arr, n);
        bubbleSort(arr, n);
        System.out.println("After sorting: ");
        printarr(arr, n);
    }
}