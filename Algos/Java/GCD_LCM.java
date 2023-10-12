package com.company;

public class GCD_LCM {
    public static void main(String[] args) {
        // System.out.println(gcd(4, 9));
        System.out.println(LCM(9, 18));
    }
    static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
    static int LCM(int a, int b){
        return a * b / gcd(a, b);
    }
}
