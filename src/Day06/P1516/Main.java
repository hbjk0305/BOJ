package Day06.P1516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] childs;
    static int[] times, indeg, mintime;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        childs = new ArrayList[n+1];
        times = new int[n+1];
        mintime = new int[n+1];
        indeg = new int[n+1];
        for (int i=0; i<=n; i++)
            childs[i] = new ArrayList<>();

        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int tmp;
            while (st.hasMoreTokens() && (tmp = Integer.parseInt(st.nextToken())) != -1){
                childs[tmp].add(i);
                indeg[i]++;
            }
        }
        for (int i=1; i<=n; i++){
            if (indeg[i] == 0){
                queue.add(i);
                mintime[i] = times[i];
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i=0; i<childs[cur].size(); i++){
                int nxt = childs[cur].get(i);
                if (mintime[nxt] < times[nxt]+mintime[cur]){
                    mintime[nxt] = times[nxt]+mintime[cur];
                }
                if (--indeg[nxt] == 0) queue.add(nxt);
            }
        }
        for (int i=1; i<=n; i++){
            System.out.println(mintime[i]);
        }
    }
}
