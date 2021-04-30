package Day07.P1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e, start, MAX = 99999999;
    static List<Edge>[] childs;
    static boolean[] visited;
    static int[] dist;
    static PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        v = Integer.parseInt(st.nextToken());
        childs = new ArrayList[v+1];
        visited = new boolean[v+1];
        dist = new int[v+1];
        for (int i=0; i<=v; i++) {
            childs[i] = new ArrayList<>();
            dist[i] = MAX;
        }
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for (int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());;
            int w = Integer.parseInt(st.nextToken());
            childs[u].add(new Edge(v, w));
        }
        dist[start] = 0;
        dfs(start);
        for (int i=1; i<=v; i++){
            if (dist[i] == MAX){
                sb.append("INF\n");
            }
            else{
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.print(sb);


    }
    static void dfs(int cur){
        visited[cur] = true;
        for (int i=0; i<childs[cur].size(); i++){
            int end = childs[cur].get(i).end;
            if (visited[end]) continue;
            int weight = childs[cur].get(i).weight;
            if (dist[cur]+weight < dist[end]){
                dist[end] = dist[cur]+weight;
                queue.add(new Edge(end, dist[end]));
            }
        }
        while (!queue.isEmpty()){
            Edge e = queue.poll();
            if (visited[e.end]) continue;
            dfs(e.end);
            break;
        }

    }
}
class Edge{
    int end;
    int weight;

    public Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
class EdgeComparator implements Comparator<Edge>{

    @Override
    public int compare(Edge o1, Edge o2) {
        return Integer.compare(o1.weight, o2.weight);
    }
}