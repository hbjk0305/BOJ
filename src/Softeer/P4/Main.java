package Softeer.P4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int n, k;
    static int[][] times;
    static int[] move;
    static long[][] dp;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        times = new int[k][n+1]; // times[i][j]: i번째 라인의 j번 작업시간.
        move = new int[n]; // move[j]: j번 작업장에서 다른 라인의 작업장으로 이동하는 시간.
        dp = new long[k][n+1];
        for (int l=1; l<=n; l++){
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<k; i++){
                times[i][l] = Integer.parseInt(st.nextToken());
            }
            if(l==n) break;
            move[l] = Integer.parseInt(st.nextToken());

        }
        for(int l=1; l<=n; l++){
            for(int j=0; j<k; j++){
                dp[j][l] = min(j, l) + times[j][l];
            }
        }
        long ans = 99999999;
        for (int i=0; i<k; i++){
            ans = Math.min(ans, dp[i][n]);
        }
        System.out.println(ans);


    }
    public static long min(int num, int line){
        long ans = dp[num][line-1];
        for(int j=0; j<k; j++){
            if(j==num) continue;
            ans = Math.min(ans, dp[j][line-1]+move[line-1]);
        }
        return ans;
    }
}