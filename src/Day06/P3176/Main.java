package Day06.P3176;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Pair>[] childs;
    static int[][] ancestor;
    static Pair[][] minmax;
    static int[] depth;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        childs = new ArrayList[n+1];
        ancestor = new int[n+1][18];
        minmax = new Pair[n+1][18];
        depth = new int[n+1];
        for (int i=0; i<=n; i++){
            childs[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            childs[a].add(new Pair(b, c));  // (end, weight)
            childs[b].add(new Pair(a, c));
        }
        dfs(1,new Pair(1, Integer.MAX_VALUE),1);
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
        }
    }
    static void dfs(int parent, Pair cur, int dep){
        minmax[cur.param1][0] = new Pair(cur.param2, cur.param2);
        ancestor[cur.param1][0] = parent;
        depth[cur.param1] = dep;
        for (int i=0; i<childs[cur.param1].size(); i++){
            dfs(cur.param1, childs[cur.param1].get(i), dep+1);
        }
    }
}
class Pair{
    int param1;
    int param2;
    public Pair(int param1, int param2) {
        this.param1 = param1;
        this.param2 = param2;
    }
}
