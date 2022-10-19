
import java.util.*;

public class MatrixChainMultiplication {

    static Scanner input = new Scanner(System.in);
    static int[][] mem = new int[100][100];

    public static void print2dArray(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void inputArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
    }

    public static int bruteForceRec(int[] matrices, int[][] subProblems, int i, int j) {

        if (i == j) {
            return 0;
        }
        subProblems[i][j]++;
        int minCount = Integer.MAX_VALUE;

        for (int iter = i; iter < j; iter++) {

            int count = bruteForceRec(matrices, subProblems, i, iter)
                    + bruteForceRec(matrices, subProblems, iter + 1, j)
                    + matrices[i - 1] * matrices[iter] * matrices[j];

            if (count < minCount) {
                minCount = count;
            }

        }

        return minCount;
    }

    public static int storedRec(int[] matrices, int[][] subProblems, int i, int j) {
        if (i == j) {
            return 0;
        }

        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        subProblems[i][j]++;
        int minCost = Integer.MAX_VALUE;

        for (int iter = i; iter < j; iter++) {
            int cost1, cost2;

            if (mem[i][iter] != -1) {
                cost1 = mem[i][iter];
            } else {
                cost1 = storedRec(matrices, subProblems, i, iter);
            }

            if (mem[iter + 1][j] != -1) {
                cost2 = mem[iter + 1][j];
            } else {
                cost2 = storedRec(matrices, subProblems, iter + 1, j);
            }

            int cost = cost1 + cost2 + matrices[i - 1] * matrices[iter] * matrices[j];

            if (cost < minCost) {
                minCost = cost;
            }
        }

        mem[i][j] = minCost;
        return minCost;
    }

    static int storedIter(int matrices[], int[][] subProblems) {
        int n = matrices.length;
        int memIter[][] = new int[n][n];

        int i, j, k, chainLength, q;

        for (i = 1; i < n; i++)
            memIter[i][i] = 0;

        for (chainLength = 2; chainLength < n; chainLength++) {
            for (i = 1; i < n - chainLength + 1; i++) {
                j = i + chainLength - 1;
                if (j == n)
                    continue;
                subProblems[i][j]++;
                memIter[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    q = memIter[i][k] + memIter[k + 1][j]
                            + matrices[i - 1] * matrices[k] * matrices[j];
                    if (q < memIter[i][j])
                        memIter[i][j] = q;
                }
            }
        }

        return memIter[1][n - 1];
    }

    public static void main(String[] a) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                mem[i][j] = -1;
            }
        }

        System.out.println("Enter size of Array");

        int size = input.nextInt();

        int[] matrices = new int[size];
        inputArray(matrices);
        int[][] subProblems = new int[size][size];
        int[][] subProblems2 = new int[size][size];
        int[][] subProblems3 = new int[size][size];
        System.out.println("Brute Force : ");
        System.out.println("Answer = " + bruteForceRec(matrices, subProblems, 1, size - 1));
        print2dArray(subProblems);

        System.out.println("Dynamic : ");
        System.out.println("Answer = " + storedRec(matrices, subProblems2, 1, size - 1));
        print2dArray(subProblems2);
        
        System.out.println("Iterative : ");
        System.out.println("Answer = " + storedIter(matrices, subProblems3));
        print2dArray(subProblems3);

    }
}
