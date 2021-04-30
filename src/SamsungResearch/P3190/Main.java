package SamsungResearch.P3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, K, L, T;
    static int[][] matrix;
    static int[] drive;
    static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};    //동남서북
    static Deque<Point> snake;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][N+1];
        drive = new int[10005];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[r][c] = 1;
        }
        snake = new LinkedList<>();
        snake.add(new Point(1, 1));
        matrix[1][1] = 9;
        L = Integer.parseInt(br.readLine());
        for (int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            int dir = 1;
            if (direction.equals("L"))  dir = -1;
            drive[time+1] = dir;
        }
        for (int i=1; i<=10000; i++){
            drive[i] += drive[i-1]+4;
            drive[i] %= 4;
//            System.out.println("time "+ i+" "+drive[i]);
        }


        int t;
        for (t=1; t<=10000; t++){
//            System.out.println("Time "+t);
//            printMatrix();
            Point head = snake.peek();
            int nx = head.x+dx[drive[t]];
            int ny = head.y+dy[drive[t]];
            if (!isValid(nx, ny)){
                break;
            }

            if (matrix[nx][ny] != 1){   //사과 발견못함.
                Point tail = snake.pollLast();
                matrix[tail.x][tail.y] = 0;
            }
            matrix[nx][ny] = 9;
            snake.addFirst(new Point(nx, ny));

        }
        System.out.println(t);

    }
    static boolean isValid(int x, int y){
        if (x<=0 || x>N || y<=0 || y>N) return false;
        if (matrix[x][y] == 9) return false;
        return true;
    }
    static void printMatrix(){
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
