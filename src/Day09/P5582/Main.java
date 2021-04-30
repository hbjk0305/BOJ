package Day09.P5582;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.SignStyle;

public class Main {
    static String str1, str2;
    static int len1, len2, ans;
    static int[][] dp = new int[4010][4010];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        len1 = str1.length();
        str2 = br.readLine();
        len2 = str2.length();
        for (int i=0; i< len1; i++){
            for (int j=0; j<len2; j++){
                int tmp = calc(i, j);
                ans = Math.max(ans, tmp);
            }
        }
        System.out.println(ans);
    }
    static int calc(int p1, int p2){
        // p1, p2로 끝나는 문자열의 lcs.
        if(p1 < 0 || p2 < 0) return 0;
        if (dp[p1][p2] != 0) return dp[p1][p2];
        if (str1.charAt(p1) == str2.charAt(p2)){
            //+1
            return dp[p1][p2] = calc(p1-1, p2-1)+1;
        }
        else return 0;

    }
}
