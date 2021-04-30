package Day08.P1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] triangle;
    static long[][] sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        triangle = new int[n+1][n+1];
        sum = new long[n+1][n+1];
        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=i; j++){
                sum[i][j] = triangle[i][j] = Integer.parseInt(st.nextToken());

            }
        }
//        sum[1][1] = triangle[1][1];
//        dfs(1,1);
        for (int i=2; i<=n; i++){
            for (int j=1; j<=i; j++){
                sum[i][j] += Math.max(sum[i-1][j], sum[i-1][j-1]);
            }
        }
        long max = 0;
//        for (int i=1; i<=n; i++){
//            for (int j=1; j<=i; j++){
//                System.out.print(sum[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int j=1; j<=n; j++){
            max = Math.max(max, sum[n][j]);
        }
        System.out.println(max);

    }
    static void dfs(int row, int col){
        if (row == n) return;
        long cur = sum[row][col];
        for (int i=0; i<2; i++){
            int nxt = triangle[row+1][col+i];
            if (nxt + cur > sum[row+1][col+i]){
                sum[row+1][col+i] = nxt + cur;
                dfs(row+1, col+i);
            }
        }
    }
}
