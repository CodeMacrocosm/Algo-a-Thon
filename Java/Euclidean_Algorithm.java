package com.company;

import java.lang.*;
import java.util.*;

// gcd means greatest common divisor
class Main {

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }


    public static void main(String[] args)
    {
        int a = 8, b = 16 , g;


        g = gcd(a, b);
        System.out.println("GCD(" + a + " , " + b
                + ") = " + g);

        a = 30;
        b = 12;
        g = gcd(a, b);
        System.out.println("GCD(" + a + " , " + b
                + ") = " + g);

        a = 26;
        b = 15;
        g = gcd(a, b);
        System.out.println("GCD(" + a + " , " + b
                + ") = " + g);
    }
}





