import java.util.*;
import java.lang.*;

class CountSort {
    public static String countSort(String arr, int n) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr.charAt(i));
        }
        StringBuilder sb = new StringBuilder(n);
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr = "";
        arr = sc.next();
        System.out.println(countSort(arr, n));
    }
}