import java.util.Scanner;

public class tag {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        Integer c = new Integer(1);
        int d = 1;
        long f = 1L;
        Long g = 1L;
        System.out.println("a.equals(b) is " + a.equals(b));
        System.out.println("a.equals(c) is " + a.equals(c));
        System.out.println("a.equals(d) is " + a.equals(d));
        System.out.println("a.equals(f) is " + a.equals(f));
        System.out.println("a.equals(g) is " + a.equals(g));
        System.out.println("a == b is " + (a == b));
        System.out.println("a == c is " + (a == c));
        System.out.println("a == d is " + (a == d));
        System.out.println("a == f is " + (a == f));
        System.out.println("a == g is " + (a == g));
        System.out.println("d == f is " + (d == f));
        System.out.println("d == g is " + (d == g));
    }
}