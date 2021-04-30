package Day07.P11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static final int INF = 99999999;
    static int[][] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n+1][n+1];
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){
                dist[i][j] = INF;
            }
        }
        m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }
        floyd();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if (i==j || dist[i][j] == INF) System.out.print("0 ");
                else System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void floyd(){
        for (int j = 1; j<=n; j++){
            for (int i=1; i<=n; i++){
                for (int k=1; k<=n; k++){
                    if (dist[i][j] == INF || dist[j][k]==INF) continue;
                    if (dist[i][j]+dist[j][k] < dist[i][k])
                        dist[i][k] = dist[i][j]+dist[j][k];
                }
            }
        }
    }
}
