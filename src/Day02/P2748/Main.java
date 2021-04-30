package Day02.P2748;
import java.util.*;
public class Main {
    static long[] fibonacci;
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n==0){
            System.out.println(0);
            return ;
        }
        if (n==1){
            System.out.println(1);
            return ;
        }
        fibonacci = new long[n+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i=2; i<=n; i++){
            fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
        }
        System.out.println(fibonacci[n]);

    }
}
