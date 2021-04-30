package Day05.P5557;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static long[][] DP;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        DP = new long[n][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        DP[0][nums[0]] = 1;
        for (int r=1; r<n-1; r++){
            int tmp = nums[r];
            for (int c=0; c<=20; c++){
                if (DP[r-1][c] == 0 ) continue;
                if (c+tmp <= 20){
                    DP[r][c+tmp] += DP[r-1][c];
                }
                if (c-tmp >= 0){
                    DP[r][c-tmp] += DP[r-1][c];
                }
            }

        }
        System.out.println(DP[n-2][nums[n-1]]);
    }

}
