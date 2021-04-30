//package Day01.P3055;
//import java.util.*;
//
//class Point{
//    int x, y, dist=0;
//    public Point(int x, int y) {
//        this(x, y, 0);
//    }
//    public Point(int x, int y, int dist) {
//        this.x = x;
//        this.y = y;
//        this.dist = dist;
//    }
//    public String toString(){
//        return "("+x +", "+y+")\tdist: "+dist;
//    }
//}
//
//public class Fail {
//    static Queue<Point> bfs = new LinkedList<>();
//    static Queue<Point> water = new LinkedList<>();
//    static int[][] map;
//    static int row, col;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        row = sc.nextInt();
//        col = sc.nextInt();
//        map = new int[row][col];
//        // 0: 비어있음. 1: 물. 2: 돌. 9: 도착지.
//        for (int r = 0; r < row; r++) {
//            String input = sc.next();
//            for (int c = 0; c < col; c++) {
//                    switch (input.charAt(c)){
//                        case 'D':
//                            map[r][c] = 9;
//                            break;
//                        case 'S':
//                            map[r][c] = 0;
//                            bfs.add(new Point(r, c, 0));
//                            break;
//                        case '.':
//                            map[r][c] = 0;
//                            break;
//                        case '*':
//                            map[r][c] = 1;
//                            water.add(new Point(r, c));
//                            break;
//                        case 'X':
//                            map[r][c] = 2;
//                            break;
//                    }
//            }
//        }   // 입력완료
//        while (!bfs.isEmpty()){
//            waterOverFlow();
//            Point now = bfs.poll();
//            System.out.println("NOW: "+now);
//            printMap();
//            if (map[now.x][now.y] == 9){
//                System.out.println(now.dist);
//                return ;
//            }
//            //상
//            move(new Point(now.x, now.y-1, now.dist+1));
//            //하
//            move(new Point(now.x, now.y+1, now.dist+1));
//            //좌
//            move(new Point(now.x-1, now.y, now.dist+1));
//            //우
//            move(new Point(now.x+1, now.y, now.dist+1));
//        }
//        System.out.println("KAKTUS");
//
//    }
//    static boolean move(Point p){
//        if (p.x >=0 && p.x < row && p.y >=0 && p.y < col){
//            if (map[p.x][p.y]==0 || map[p.x][p.y]==9){
//                bfs.add(p);
//                return true;
//            }
//        }
//        return false;
//    }
//    static void makeWater(Point p){
//        if (p.x >=0 && p.x < row && p.y >=0 && p.y < col){
//            if (map[p.x][p.y]==0){
//                map[p.x][p.y] = 1;
//                water.add(p);
//            }
//        }
//    }
//    static void waterOverFlow(){
//        int num = water.size();
//        for (int i = 0; i < num; i++){
//            Point p = water.get(i);
//            //상
//            makeWater(new Point(p.x, p.y-1));
//            //하
//            makeWater(new Point(p.x, p.y+1));
//            //좌
//            makeWater(new Point(p.x-1, p.y));
//            //우
//            makeWater(new Point(p.x+1, p.y));
//        }
//
//    }
//    static void printMap(){
//        for (int i=0; i< row; i++){
//            for (int j=0; j<col; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//}
