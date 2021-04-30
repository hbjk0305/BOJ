package Day07.P5719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, start, dest;
    static long[] dist = new long[501];
    static final long INF = 999999999;
    static List<Edge>[] childs = new ArrayList[501];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n==0 && m==0) return ;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());
            init();
            for (int i=0; i<m; i++){
//                childs[i].add(new Edge())
            }

        }
    }
    public static void init(){
        for (int i=0; i<n; i++){
            dist[i] = INF;
            childs[i] = new ArrayList<>();
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
