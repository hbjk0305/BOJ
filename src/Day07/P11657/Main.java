package Day07.P11657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final long MAX = 999999999;
    static int n, m;
    static long[] dist;
    static List<Edge> edges;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new long[n+1];
        for (int i=0; i<=n; i++){
            dist[i] = MAX;
//            childs[i] = new ArrayList<>();
        }
        dist[1] = 0;
        m = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }
        for(int i=1; i<n; i++){
            for (Edge e: edges){
                relax(e);
            }
        }

        for (Edge e: edges){
            if (relax(e)){
                System.out.println(-1);
                return;
            }
        }
        for (int i=2; i<=n; i++){
            if (dist[i] == MAX){
                sb.append("-1\n");
            }
            else {
                sb.append(dist[i]).append('\n');
            }
        }

        System.out.print(sb);
    }
    public static boolean relax(Edge e){
        // update되면 true반환
        if (dist[e.start] == MAX) return false; // 요 부분 없어서 틀렸음.
        if (dist[e.end] > dist[e.start]+e.weight){
            dist[e.end] = dist[e.start]+e.weight;
            return true;
        }
        return false;
    }


}
class Edge{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
