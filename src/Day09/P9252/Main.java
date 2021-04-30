package Day09.P9252;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str1, str2;
    static int len1, len2;
    static int[][] dp = new int[1010][1010];
    static Point[][] tracking = new Point[1010][1010];
    public static void main(String[] args) throws Exception {
        for (int i=0; i<1010; i++){
            for (int j=0; j<1010; j++){
                dp[i][j] = -1;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        len1 = str1.length()-1;
        str2 = br.readLine();
        len2 = str2.length()-1;
        int ans = calc(len1, len2);

        StringBuilder sb = new StringBuilder();
        System.out.println(ans);
        if (ans == 0) return;

        while (len1>=0 && len2 >= 0){
            if (str1.charAt(len1) == str2.charAt(len2)){
                sb.append(str1.charAt(len1));
            }
            Point p = tracking[len1][len2];
//            System.out.println(p);
            len1 = p.s1;
            len2 = p.s2;
        }
        System.out.print(sb.reverse());
    }
    static int calc(int p1, int p2){
        // p1, p2로 끝나는 문자열의 lcs.
        if(p1 < 0 || p2 < 0) return 0;
        if (dp[p1][p2] >= 0) return dp[p1][p2];
        if (str1.charAt(p1) == str2.charAt(p2)){
            //+1
            tracking[p1][p2] = new Point(p1-1, p2-1);
            return dp[p1][p2] = calc(p1 - 1, p2 - 1) + 1;
        }
        else{
            int tmp1 = calc(p1-1, p2);
            int tmp2 = calc(p1, p2-1);
            if (tmp1 > tmp2){
                tracking[p1][p2] = new Point(p1-1, p2);
                return dp[p1][p2] = tmp1;
            }
            else{
                tracking[p1][p2] = new Point(p1, p2-1);
                return dp[p1][p2] = tmp2;
            }
        }

    }
}
class Point{
    int s1;
    int s2;

    public Point(int s1, int s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return "Point{" +
                "r=" + s1 +
                ", c=" + s2 +
                '}';
    }
}