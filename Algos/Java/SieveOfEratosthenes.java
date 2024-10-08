import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n; // It is the limit
        System.out.println("Enter the number upto which the number of prime numbers must be printed here");
        n=sc.nextInt();
        sc.close();
        boolean[] primes = sieveOfEratosthenes(n);

        // It prints all prime numbers up to n
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        /*
        Creating a boolean array "isPrime[]" and initializing all entries it as true. A value in isPrime[i] will finally be false if i is not a prime number, else true.
        */
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Here we assume all numbers are prime initially
        isPrime[0] = false; // 0 is not a prime number
        isPrime[1] = false; // 1 is not a prime number

        // We will start marking multiples of each number
        for (int i = 2; i * i <= n; i++) {
            // If isPrime[i] is not changed, then it is a prime number
            if (isPrime[i]) {
                // We are updating all multiples of i as non-prime numbers
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

}
