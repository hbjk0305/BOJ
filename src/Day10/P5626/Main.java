package Day10.P5626;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int mod = 1000000007;
    static final int invalid = -1;
    static int n;
    static int[] steps;
//    static int[][] dp = new int[10010][5010];  //dp[i][j]: i번째 제단까지 진행했을 때, 높이가 j인 경우의 수.
    static int[][] newdp = new int[2][5010];
    static int prev = 0, cur = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        steps = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            steps[i] = Integer.parseInt(st.nextToken());
        }
        if (steps[1] > 0 || steps[n] > 0){
            System.out.println(0);
            return ;
        }
        newdp[prev][0] = 1;
        for (int i=2; i<=n; i++){
            int start = 0, end = n/2;
            for (int c=0; c<=5000; c++){
                newdp[cur][c] = 0;
                //cur 메모리를 초기화해야 함.
            }
            if (steps[i] >= 0){
                start = steps[i];
                end = steps[i];
            }
            for (int j= start; j<=end; j++){
                if (j-1 >= 0) {
                    newdp[cur][j] += newdp[prev][j - 1];
                    newdp[cur][j] %= mod;
                }
                newdp[cur][j] += newdp[prev][j];
                newdp[cur][j] %= mod;
                if (j+1<=5000){
                    newdp[cur][j] += newdp[prev][j+1];
                    newdp[cur][j] %= mod;
                }
            }
            prev = (prev+1)%2;
            cur = (cur+1)%2;
        }
        System.out.println(newdp[prev][0]);

//        dp[1][0] = 1;
//        for (int i=2; i<=n; i++){
////            i번째 제단에서 가능한 높이 경우의 수를 넣는다.
//            if (steps[i] >= 0){
//                int j = steps[i];
//                int a = 0, b = 0, c = 0;
//                if (j - 1 >= 0)
//                    a = Math.max(0, dp[i - 1][j - 1]);
//                b = Math.max(0, dp[i - 1][j]);
//                c = Math.max(0, dp[i - 1][j + 1]);
//                dp[i][j] = (int) ((long) a + b + c) % mod;
//            }
//            else {
//                for (int j = 0; j <= n / 2; j++) {
////                i번째 제단이 j의 높이를 갖는 경우의 수.
//                    int a = 0, b = 0, c = 0;
//                    if (j - 1 >= 0)
//                        a = Math.max(0, dp[i - 1][j - 1]);
//                    b = Math.max(0, dp[i - 1][j]);
//                    c = Math.max(0, dp[i - 1][j + 1]);
//                    dp[i][j] = (int) ((long) a + b + c) % mod;
////                System.out.print(dp[i][j]+" ");
//                }
//            }
////            System.out.println();
//
//        }
//        System.out.println(dp[n][0]);

    }
}
