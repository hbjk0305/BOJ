package Day07.P11266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int v, e, cnt, num = 1;
    static boolean[] ans;
    static int[] visit_order;
    static List<Integer>[] childs;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ans = new boolean[v+1];
        visit_order = new int[v+1];
        childs = new ArrayList[v+1];
        for (int i=0; i<= v; i++)
            childs[i] = new ArrayList<>();
        for (int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            childs[a].add(b);
            childs[b].add(a);
        }
        for (int i=1; i<=v; i++){
            if (visit_order[i] == 0) {
                dfs(0, i, true);
            }
        }
        for (int i=1; i<=v; i++){
            if (ans[i]) cnt++;
        }
        System.out.println(cnt);
        for (int i=1; i<=v; i++){
            if (ans[i]) System.out.print(i+" ");
        }
    }
    static int dfs(int parent, int cur, boolean isRoot){


        int chlcnt = 0;
//        System.out.println("I am "+cur);
        visit_order[cur] = num++;
        int min_visit_order = visit_order[cur];  //내 자식들이 만날 수 있는 점들 중 가장 작은 점.
        for (int i=0; i<childs[cur].size(); i++){
            int nxt = childs[cur].get(i);
            if (nxt == parent) continue;
            if (visit_order[nxt] != 0){
                //나 때문에 잘리는 친구는 아니지만 리턴할때 필요한 정보이다.
                min_visit_order = Math.min(min_visit_order, visit_order[nxt]);
            }
            else {
                int tmp = dfs(cur, nxt, false);
                min_visit_order = Math.min(min_visit_order, tmp);
                if (!isRoot && tmp >= visit_order[cur]){
                    // 단절점. 루트일 경우는 예외.
                    ans[cur] = true;
                }
                chlcnt++;   // 새롭게 방문하는 경우만 자식.

            }
        }
//        System.out.println(cur+"'s Min visit order "+min_visit_order);
        if (childs[cur].size()==1) return visit_order[cur]; //리프노드인 경우 단절점 처리 암함.
        if (isRoot){
            //자식이 두개이상이면 단절점.
            if (chlcnt >= 2) {
                ans[cur] = true;
            }
        }
        return min_visit_order; //내가 만난 점 중에서 방문 순서가 가장 낮은 점을 반환.
    }
}
