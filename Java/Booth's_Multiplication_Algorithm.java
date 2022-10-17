package com.company;


class Main
{


    static void add(int a[], int x[], int qr)
    {
        int i, c = 0;

        for (i = 0; i < qr; i++)
        {


            a[i] = a[i] + x[i] + c;

            if (a[i] > 1)
            {
                a[i] = a[i] % 2;
                c = 1;
            }
            else
            {
                c = 0;
            }
        }
    }


    static void complement(int a[], int n)
    {
        int i;
        int[] x = new int[8];
        x[0] = 1;

        for (i = 0; i < n; i++)
        {
            a[i] = (a[i] + 1) % 2;
        }
        add(a, x, n);
    }


    static void rightShift(int ac[], int qr[],
                           int qn, int qrn)
    {
        int temp, i;
        temp = ac[0];
        qn = qr[0];

        System.out.print("\t\trightShift\t");

        for (i = 0; i < qrn - 1; i++)
        {
            ac[i] = ac[i + 1];
            qr[i] = qr[i + 1];
        }
        qr[qrn - 1] = temp;
    }


    static void display(int ac[], int qr[], int qrn)
    {
        int i;


        for (i = qrn - 1; i >= 0; i--)
        {
            System.out.print(ac[i]);
        }
        System.out.print("\t");


        for (i = qrn - 1; i >= 0; i--)
        {
            System.out.print(qr[i]);
        }
    }


    static void boothAlgorithm(int br[], int qr[], int mt[],
                               int qrn, int sc)
    {

        int qn = 0;
        int[] ac = new int[10];
        int temp = 0;
        System.out.print("qn\tq[n+1]\t\tBR\t\tAC\tQR\t\tsc\n");
        System.out.print("\t\t\tinitial\t\t");

        display(ac, qr, qrn);
        System.out.print("\t\t" + sc + "\n");

        while (sc != 0)
        {
            System.out.print(qr[0] + "\t" + qn);


            if ((qn + qr[0]) == 1)
            {
                if (temp == 0)
                {


                    add(ac, mt, qrn);
                    System.out.print("\t\tA = A - BR\t");

                    for (int i = qrn - 1; i >= 0; i--)
                    {
                        System.out.print(ac[i]);
                    }
                    temp = 1;
                }


                else if (temp == 1)
                {

                    add(ac, br, qrn);
                    System.out.print("\t\tA = A + BR\t");

                    for (int i = qrn - 1; i >= 0; i--)
                    {
                        System.out.print(ac[i]);
                    }
                    temp = 0;
                }
                System.out.print("\n\t");
                rightShift(ac, qr, qn, qrn);
            }


            else if (qn - qr[0] == 0)
            {
                rightShift(ac, qr, qn, qrn);
            }

            display(ac, qr, qrn);

            System.out.print("\t");


            sc--;
            System.out.print("\t" + sc + "\n");
        }
    }

    static void reverse(int a[])
    {
        int i, k, n = a.length;
        int t;
        for (i = 0; i < n / 2; i++)
        {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }


    public static void main(String[] args)
    {
        int[] mt = new int[10];
        int sc;
        int brn, qrn;


        brn = 4;


        int br[] = {0, 1, 1, 0};


        for (int i = brn - 1; i >= 0; i--)
        {
            mt[i] = br[i];
        }

        reverse(br);

        complement(mt, brn);


        qrn = 4;


        sc = qrn;


        int qr[] = {0, 0, 1, 1};
        reverse(qr);

        boothAlgorithm(br, qr, mt, qrn, sc);

        System.out.print("\n"
                + "Solution = ");

        for (int i = qrn - 1; i >= 0; i--)
        {
            System.out.print(qr[i]);
        }
    }
}



