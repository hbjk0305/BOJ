package SamsungResearch.P1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] matrix;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        matrix = new int[n+1][n+1];
        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1;  j<=i; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                matrix[i][j] += Math.max(matrix[i-1][j-1], matrix[i-1][j]);
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            ans = Math.max(ans, matrix[n][i]);
        }
        System.out.println(ans);
    }
}
