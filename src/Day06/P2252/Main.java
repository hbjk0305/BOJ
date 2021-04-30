package Day06.P2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m, cnt, MAX = 99999999;
    static int[][] dist, graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        dist = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = MAX;
                if (i==j) graph[i][j] = 0;
            }
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
//        printGraph();

        for (int mid=1;mid<=n;mid++){
            for (int start=1;start<=n;start++){
                for (int end=1;end<=n;end++){
                    if (graph[start][end] > graph[start][mid] + graph[mid][end]){
                        // 더 가까운 경로가 있을 경우 최신화
                        graph[start][end] = graph[start][mid] + graph[mid][end];
                        // 직전정점 행렬 최신화

                    }
                }
            }
        }
        for (int person = 1; person<=n; person++){
            int small = 0, tall = 0;
            for (int i=1; i<=n; i++){
                if (graph[i][person] > 0 && graph[i][person] < MAX) small++;
                if (graph[person][i] > 0 && graph[person][i] < MAX) tall++;
            }
            if (small+tall == n-1) cnt++;
        }
        System.out.println(cnt);

    }
    static void printGraph(){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }


}
