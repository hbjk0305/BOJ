package SamsungResearch.P12100;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, ans;
    static int[][] matrix;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve(0, matrix));


    }
    static public int solve(int depth, int[][] problem){
        int tmp = 0;
        if (depth == 5){
            return findMax(problem);
        }
        tmp = Math.max(tmp, solve(depth-1, moveL(problem, true)));
        tmp = Math.max(tmp, solve(depth-1, moveL(problem, false)));
        tmp = Math.max(tmp, solve(depth-1, moveU(problem, true)));
        tmp = Math.max(tmp, solve(depth-1, moveU(problem, false)));
        return tmp;
    }
    static public int[][] moveL(int[][] matrix, boolean isLeft){
        for (int i=0; i<n; i++){
            matrix = moverow(matrix, i, isLeft);
        }
        return matrix;
    }
    static public int[][] moveU(int[][] matrix, boolean isUp){
        for (int i=0; i<n; i++){
            matrix = movecol(matrix, i, isUp);
        }
        return matrix;
    }
    static public int[][] moverow(int[][] matrix, int row, boolean isLeft){
        Queue<Integer> que = new LinkedList<>();
        for (int i=0; i<n; i++){
            int tmp = isLeft? i : n-1-i;
            que.add(matrix[row][i]);
            matrix[row][i]=0;
        }
        int position = 0;
        while (!que.isEmpty()){
            int top = que.poll();
            if (top==0){
                continue;
            }
            int tmp = isLeft? position:n-1-position;
            if (matrix[row][tmp] == top){
                matrix[row][tmp] *=2;
                position ++;
            }
            else{
                matrix[row][tmp] = top;
            }
        }
        return matrix;
    }
    static public int[][] movecol(int[][] matrix, int col, boolean isUp){
        Queue<Integer> que = new LinkedList<>();
        for (int i=0; i<n; i++){
            int tmp = isUp? i : n-1-i;
            que.add(matrix[tmp][col]);
            matrix[tmp][col]=0;
        }
        int position = 0;
//        System.out.println("col"+col);
        while (!que.isEmpty()){
            int top = que.poll();
//            System.out.println(top);
//            printMatrix(matrix);
            if (top==0){
                continue;
            }
            int tmp = isUp? position:n-1-position;
//            System.out.println(matrix[tmp][col]+" "+top);
            if (matrix[tmp][col] == top){
                matrix[tmp][col] += top;
                position ++;
            }
            else{
                position++;
                matrix[tmp][col] = top;
            }

        }
        return matrix;
    }
    static public void printMatrix(int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int findMax(int[][] matrix){
        int ans = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                ans = Math.max(ans, matrix[i][j]);
            }
        }
        return ans;
    }
}
