package Day10.P10714;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long[] pieces;
    static long[][] dp; //dp[i][j]: J군이 바라볼 때, 왼쪽에는 i번째, 오른쪽에는 j번째 케이크. 이 상태에서 가장 많이 먹을 수 있는 값.

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pieces = new long[n];
        dp = new long[n+1][n+1];
        for (int i=0; i<n; i++){
            pieces[i] = Long.parseLong(br.readLine());
        }
        if (n==1){
            System.out.println(pieces[0]);
            return;
        }
        long ans = 0;
        for (int i=0; i<n; i++){

            ans = Math.max(ans, pieces[i]+Ieat((i+1)%n, (i-1+n)%n));
        }
        System.out.println(ans);
    }
    static long Jeat(int l, int r){
//        J군이 먹을 차례인데, 왼쪽은 l번 조각, 오른쪽은 r번 조각이 있다.
//        J군이 가장 많이 먹은 경우 크기를 반환하라.
        if (l==r) return pieces[l];
        if (dp[l][r]!= 0) return dp[l][r];
        long lefteat = Ieat((l+1)%n, r)+pieces[l];
        long righteat = Ieat(l, (r-1+n)%n) + pieces[r];
        return dp[l][r] = Math.max(lefteat, righteat);


    }
    static long Ieat(int l, int r){
//        J군이 먹을 차례인데, 왼쪽은 l번 조각, 오른쪽은 r번 조각이 있다.
//        J 군이 가장 많이 먹은 경우 크기를 반환하라!!!!
        if (l==r) return 0;
        if (dp[l][r]!= 0) return dp[l][r];
        if (pieces[l] > pieces[r]){
            return Jeat((l+1)%n, r);
        }else{
            return Jeat(l, (r-1+n)%n);
        }

    }
}
