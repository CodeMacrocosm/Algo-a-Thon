import java.util.Scanner;

public class StrobogrammaticNumber {
    public static void SN(long no) {
        String s = String.valueOf(no);
        StringBuilder ns = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '6') {
                ns.append("9");
            } else if (s.charAt(i) == '9') {
                ns.append("6");
            } else {
                ns.append(s.charAt(i));
            }
        }
        if (ns.toString().equals(s)) {
            System.out.println("It is a Strobogramattic Number");
        } else {
            System.out.println("It is not a Strobogramattic Number");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        SN(n);
    }
}
