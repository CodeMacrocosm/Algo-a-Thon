import java.util.*;

public class InsertionSort {
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static void main(String a[]) {
        int n;
        System.out.print("Enter the number of elements in an array: ");

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements of the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Before Insertion Sort");

        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();

        insertionSort(arr);

        System.out.println("After Insertion Sort");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
