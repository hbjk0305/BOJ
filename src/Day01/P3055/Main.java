package Day01.P3055;

import java.awt.image.Kernel;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int row, col;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        map = new char[row][col];
        dp = new int[row][col];
        queue = new LinkedList<>();

        Point st = null;
        for (int r = 0; r < row; r++){
            String line = sc.next();
            for (int c = 0; c<col; c++){
                map[r][c] = line.charAt(c);
                if (map[r][c] == '*'){
                    queue.add(new Point(r, c, '*'));
                }
                if (map[r][c]=='S'){
                    st = new Point(r, c, 'S');
                }
            }
        }
        queue.add(st);

        while(!queue.isEmpty()){
//            1. 큐에서 꺼내옴.
            Point now = queue.poll();
//            2. 목적지인가? if p== D
            if (map[now.x][now.y] == 'D'){
                System.out.println(dp[now.x][now.y]);
                return ;
            }
//            3. 갈 수 있는 곳을 순회 for(상하좌우)
            for (int i=0; i<4; i++) {
//                4. 갈 수 있는ㄴ가? if 맵을 벗어나지 않고 X나 *이 아니고
                int DX = now.x+dx[i];
                int DY = now.y+dy[i];
                if (DX < 0 || DY < 0 || DX >= row || DY >= col){
                    continue;
                }
                char status = map[DX][DY];
                if (now.type == '*'){   // 물인 경우
                    if (status == '.' || status =='S'){
//                    5. 체크인 dp[r][c]=time
                        map[DX][DY] = '*';
                        queue.add(new Point(DX, DY, '*'));
                    }
                }
                if (now.type == 'S') {   // 고슴도치인 경우
                    if (status == '.'){
//                    5. 체크인 dp[r][c]=time
                        dp[DX][DY] = dp[now.x][now.y]+1;
                        map[DX][DY] = 'S';
                        queue.add(new Point(DX, DY, 'S'));
                    }
                    else if (status == 'D'){
                        System.out.println(dp[now.x][now.y]+1);
                        return ;
                    }
                }
//                    6. 큐에 넣음. queue.add(next)
            }
        }
        System.out.println("KAKTUS");
    }

    static void printMap(){
        for (int i=0; i< row; i++){
            for (int j=0; j<col; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Point{
    int x, y;
    char type;
    public Point(int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public String toString(){
        return "("+x +", "+y+")";
    }
}