package SamsungResearch.P14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X, Y, D, ans;
    static int[][] matrix;
//    static boolean[][] visited;
    static int[] dy = {0,1,0,-1}, dx = {-1,0,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
//        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        for (int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        matrix[X][Y] = 2;
        ans ++;
        dfs(X, Y, D);
        System.out.println(ans);
    }
    static void dfs(int x, int y, int d){
        System.out.println(String.format("(%d, %d) %d", x, y, d));
        printMat(x, y, d);
        boolean flag = true;
        for (int i=1; i<=4; i++){
            int nd = (d-i+4)%4;
            int nx = x+dx[nd];
            int ny = y + dy[nd];
            if (isValid(nx, ny) && matrix[nx][ny]==0){
                matrix[nx][ny]=2;
                ans ++;
                flag = false;
                dfs(nx, ny, nd);
                return ;
            }
        }
        if(flag) {
            int nd = (d - 2 + 4) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];
            if (isValid(nx, ny) && matrix[nx][ny]!=1) {
                dfs(nx, ny, d);
                return ;
            }
        }


    }
    static boolean isValid(int x, int y){
        if (x<0 || x>=N || y<0 || y>=M) return false;
        return true;

    }
    static void printMat(int x, int y, int d){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (i==x && j==y){
                    String dir = "* ";
                    switch (d){
                        case 0:
                            dir = "↑ ";
                            break;
                        case 1:
                            dir = "→ ";
                            break;
                        case 2:
                            dir = "↓ ";
                            break;
                        case 3:
                            dir = "← ";
                            break;
                    }
                    sb.append(dir);
                }
                else{
                    sb.append(matrix[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
