package Day06.P11438;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int n,m;
    static int[][] ancestor;
    static int[] depth;
    static boolean[] visited;
    static List<Integer>[] childs;
    static void dfs(int parent, int cur, int dep){
        if (visited[cur]) return;
        visited[cur] = true;
        depth[cur] = dep;
        ancestor[cur][0] = parent;
        for (int i=0; i<childs[cur].size(); i++){
            dfs(cur, childs[cur].get(i), dep+1);
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        childs = new ArrayList[n+1];
        visited = new boolean[n+1];
        depth = new int[n+1];
        ancestor = new int[n+1][18];
        for (int i=0; i<=n; i++)
            childs[i] = new ArrayList<>();
        // 초기화 끝.

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            childs[a].add(b);
            childs[b].add(a);
        }
        dfs(1,1,1); //root의 조상은 자기자신으로.
        for (int i=1; i<=17; i++){  //2^i번째 조상.
            for (int j=1; j<=n; j++){   //1번 노드, 2번 노드, ...,    n번 노드
                int tmp = ancestor[j][i-1];
                ancestor[j][i] = ancestor[tmp][i-1]; // 나의 8(2^3)번째 조상은 나의 4(2^2)번째 조상의 4(2^2)번째 조상이다.
            }
        }
//        printAncestor();
//        System.out.println("DEPTH TABLE");
//        for (int i=1; i<=n; i++){
//            System.out.print(depth[i]+" ");
//        }
        m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append('\n');

        }
        System.out.print(sb);

    }
    static int LCA(int a, int b){
//        System.out.println("LCA("+a+", "+b+")");
        if (a==b) return a;
        if (depth[a] == depth[b]){
            for (int k = 17; k>=0; k--){
                if (ancestor[a][k] != ancestor[b][k]){
                    a = ancestor[a][k];
                    b = ancestor[b][k];
                }
            }
            return ancestor[a][0];
        }
        else{
            if (depth[a] < depth[b]){
                int tmp = a;
                a = b;
                b = tmp;
            }
            //depth[a] > depth[b]
            int diff = depth[a]-depth[b];   // ex) 13=8+4+1
            for (int i=0, j=1; i<=17; i++, j*=2){
                if ((diff & j) !=0){
//                    System.out.println(diff+"&"+j+"="+(diff & j));
                    a = ancestor[a][i];
                }
            }
            return LCA(a, b);
        }
    }
    static void printAncestor(){
        for (int i=1; i<=n; i++){
            System.out.print(i+": ");
            for (int j=0; j<=17; j++){
                System.out.print(ancestor[i][j]+" ");
            }
            System.out.println();
        }
    }
}
