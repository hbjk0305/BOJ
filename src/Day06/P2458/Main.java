package Day06.P2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent, tall, small, indegree, outdegree;
    static List<Integer>[] childs;
    static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        childs = new ArrayList[n+1];
        parent = new int[n+1];
        tall = new int[n+1];
        small = new int[n+1];
        indegree = new int[n+1];
        outdegree = new int[n+1];
        for (int i=0; i<=n; i++){
            childs[i] = new ArrayList<>();
            parent[i] = i;
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent[b] = a;
            childs[a].add(b);
            indegree[b]++;
            outdegree[a]++;
        }
        queue = new LinkedList<>();
        for (int i=1; i<=n; i++){
            if (indegree[i]==0){
                queue.add(i);
                small[i] = 0;
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i=0; i<childs[cur].size(); i++){
                int nxt = childs[cur].get(i);
                indegree[nxt]--;
                small[nxt] += (small[cur]+1);
                if (indegree[nxt] == 0)
                    queue.add(nxt);
            }
        }
        for (int i=1; i<=n; i++){
            System.out.print(small[i]+" ");
        }

    }
}
