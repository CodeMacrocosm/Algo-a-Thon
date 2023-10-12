import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < m; j++) {
                int element;
                element = sc.nextInt();
                result += element;
            }
            System.out.println(result);
        }
    }
}
