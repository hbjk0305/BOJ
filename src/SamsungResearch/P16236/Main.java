package SamsungResearch.P16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x, y, dist;
    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class PointComparator implements Comparator<Point>{
    @Override
    public int compare(Point p1, Point p2){
        if (p1.dist == p2.dist){
            if (p1.x == p2.x){
                return Integer.compare(p1.y, p2.y);
            }
            return Integer.compare(p1.x, p2.x);
        }
        return Integer.compare(p1.dist, p2.dist);
    }
}

public class Main {
    static int N, now = 2, ans, eaten;
    static int[][] matrix;
    static boolean [][] visited;
    static Queue<Point> que;
    static PriorityQueue<Point> eat;
    static int[] dx = {0,-1,0,1}, dy={-1,0,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        reset();
        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 9){
                    que.add(new Point(i, j, 0));
                    matrix[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        find();
        while (!eat.isEmpty()){
            Point pos = eat.poll();
//            print(pos);
            ans += pos.dist;
            eaten ++;
            if (eaten == now){
                now++;
                eaten = 0;
            }
            reset();
            que.add(new Point(pos.x, pos.y, 0));
            visited[pos.x][pos.y] = true;
//            System.out.println("Size: "+now+" Move to ("+pos.x+", "+pos.y+")\t"+ans);
            matrix[pos.x][pos.y] = 0;
            find();

        }
        System.out.println(ans);

    }
    static void reset(){
        que = new LinkedList<>();
        eat = new PriorityQueue<>(new PointComparator());
        visited = new boolean[N][N];
    }
    static void find(){
        while (!que.isEmpty()){
            Point pos = que.poll();

            for (int i=0; i<4; i++){
                int newX = pos.x + dx[i];
                int newY = pos.y + dy[i];
                if (isValid(newX, newY, now)){
//                    System.out.println("("+newX+", "+newY+")");
                    visited[newX][newY] = true;
                    if (matrix[newX][newY] > 0 &&  matrix[newX][newY] < now){
                        eat.add(new Point(newX, newY, pos.dist+1));
                    }
                    else {
                        que.add(new Point(newX, newY, pos.dist + 1));
                    }
                }
            }
        }
    }
    static boolean isValid(int x, int y, int now){
        if (x<0 || x>=N || y<0 || y>=N) return false;
        if (matrix[x][y] > now) return false;
        return !visited[x][y];
    }
    static void print(Point p){
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (p.x == i && p.y == j){
                    sb.append("* ");
                }
                else{
                    sb.append(matrix[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}

