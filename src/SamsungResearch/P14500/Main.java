package SamsungResearch.P14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.SignStyle;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1}, dy={-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }   //입력 끝
        int ans = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                visited[i][j] = true;
                ans = Math.max(ans, dfs(i,j,1));
                visited[i][j] = false;
            }
        }
        System.out.println(ans);


    }
    static int dfs(int x, int y, int depth){
        int ans = 0;
        if (depth ==4){
            return matrix[x][y];
        }
        if (depth ==2){
            for (int i=0; i<4; i++){
                for (int j=0; j<4; j++){
                    if (i==j) continue;
                    if (isValid(x+dx[i], y+dy[i]) && isValid(x+dx[j], y+dy[j])){
                        ans = Math.max(ans, matrix[x+dx[i]][y+dy[i]] + matrix[x+dx[j]][y+dy[j]]);
                    }
                }
            }
        }
        for (int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if (isValid(newX, newY)){
                visited[newX][newY] = true;
                ans = Math.max(ans, dfs(newX, newY, depth+1));
                visited[newX][newY] = false;
            }
        }
        return ans+matrix[x][y];
    }
    static boolean isValid(int x, int y){
        if (x<0 || x>=N) return false;
        if (y<0 || y>=M) return false;
        return !visited[x][y];
    }
}
