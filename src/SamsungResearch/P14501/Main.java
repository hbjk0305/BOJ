package SamsungResearch.P14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] problem;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        problem = new int[2][N+1];
        dp = new int[N+1];   //0번 row는 시작 시간. 1번 row는 지금까지 번 돈.
        for (int i =1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());   //0번 row가 time
            int price = Integer.parseInt(st.nextToken());   //1번 row가 price
            if (i+time-1 > N) continue;
            problem[0][i] = time;
            problem[1][i] = price;
        }
        for (int i = 1; i<=N; i++){
            int end = problem[0][i] + i-1;
            int newVal = findMax(i-1) + problem[1][i];
            if (dp[end] < newVal){
                dp[end] = newVal;
            }
        }

        for (int i=N; i>0; i--){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

    }
    static int findMax(int n){
        int ans = 0;
        for (int i=1; i<=n; i++)
            ans = Math.max(ans, dp[i]);
        return ans;
    }

}
