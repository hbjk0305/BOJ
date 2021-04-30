package Day05.P11050;

import java.util.Scanner;

public class Main {
    static int[][] combination;
    static int n, k;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        combination = new int[n+1][n+1];
        System.out.println(combination(n,k));
    }
    static int combination(int n, int k){
        if (k==1) return combination[n][k] = n%10007;
        if (n == k || k == 0) return combination[n][k] = 1;
        if (combination[n][k] != 0){
            return combination[n][k];
        }
        else return combination[n][k] = (combination(n-1, k-1)+combination(n-1, k))%10007;
    }
}
