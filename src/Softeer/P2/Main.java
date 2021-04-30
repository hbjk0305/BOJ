package Softeer.P2;
import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int[][] times, move;
    static long[][] dp;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        times = new int[2][n+1];
        move = new int[2][n];
        dp = new long[2][n+1];
        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[0][i] = Integer.parseInt(st.nextToken());
            times[1][i] = Integer.parseInt(st.nextToken());
            if (i==n)
                break;
            move[0][i] = Integer.parseInt(st.nextToken());
            move[1][i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            dp[0][i] = Math.min(dp[0][i-1], dp[1][i-1]+move[1][i-1]) + times[0][i];
            dp[1][i] = Math.min(dp[1][i-1], dp[0][i-1]+move[0][i-1]) + times[1][i];
        }
        System.out.println(Math.min(dp[0][n], dp[1][n]));


    }
}