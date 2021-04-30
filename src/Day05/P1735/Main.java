package Day05.P1735;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int del1 = sc.nextInt();
        int den1 = sc.nextInt();
        int del2 = sc.nextInt();
        int den2 = sc.nextInt();

        int del = del1*den2 + del2 * den1;
        int den = den1*den2;
        int gcd = GCD(del, den);
        del /= gcd;
        den /= gcd;
        System.out.println(del+" "+den);


    }
    static int GCD(int a, int b){
        if (b == 0) return a;
        return GCD(b, a%b);
    }
}
