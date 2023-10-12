package com.kraken;
import java.util.*;
public class towerOfHanoi {
    public static void Hanoi(int n, String src, String help, String dest)
    {
        if(n==1)
        {
            System.out.println("Transfer disk from "+src+" to "+dest);
            return;
        }
        Hanoi(n-1,src,dest,help);
        System.out.println("Transfer disk from "+src+" to "+dest);
        Hanoi(n-1,help,src,dest);
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Hanoi(n,"A","B","C");
    }
}
