class Stepping_stairs {
  
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
 
   
    static int countWays(int s)
    {
        return fib(s + 1);
    }
 
    public static void main(String args[])
    {
        int s = 4;
        System.out.println("Number of ways = " + countWays(s));
    }
}