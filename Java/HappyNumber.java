// a happy number is a number which eventually reaches 1 when replaced by the sum of the square of each digit
class Solution {
    public boolean isHappy(int n) {
       Set<Integer> seen = new HashSet<>();
        // if n is not 1 or hashset does not contain n, then add n 
        // and perform the function
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    // n = 19
    private int getNext(int n){
        int sum = 0;
        while(n > 0){
            // 19 % 10 = 9
            int d = n % 10;
            // 19 / 10 = 1
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
}
