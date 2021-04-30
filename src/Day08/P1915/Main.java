package Day08.P1915;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] matrix, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n+1][m+1];
        dp = new int[n+1][m+1];     // (i, j)를 오른쪽 아래로 했을 때 가장 큰 정사각형.
        for (int i=1; i<=n; i++){
            String line = br.readLine();
            for (int j=1; j<=m; j++){
                matrix[i][j] = line.charAt(j-1) - '0';
            }
        }
        int max = 0;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (matrix[i][j] == 0) continue;    // 우측하단의 점이 0이면 정사각형을 만들 수 없다.
                //이웃한 곳들(왼쪽, 위쪽, 왼쪽위)을 조사하자.
                // 그 중 가장 작은 것을 보자.
                int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                dp[i][j] = min+1;
                max = Math.max(dp[i][j], max);

            }
        }
        System.out.println(max*max);
//        for (int i=1; i<=n; i++){
//            for (int j=1; j<=m; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
