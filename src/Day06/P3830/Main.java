package Day06.P3830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long[] weights;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n==0 & m== 0) break;
            weights = new long[n+1];
            initParent(n);
            for (int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().charAt(0)=='!'){
                    //무게 재기
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    setWeight(a, b, w);
                }
                else{
                    // 교수님의 질문
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    long res = compare(a, b);
                    if (res == Long.MAX_VALUE){
                        sb.append("UNKNOWN\n");
                    }
                    else{
                        sb.append(res).append('\n');
                    }
                }
            }
        }
        System.out.print(sb);
    }
    static void initParent(int n){
//        System.out.println("Init()");
        parent = new int[n+1];
        for (int i=0; i<=n; i++){
            parent[i] = i;
        }
    }
    static int find(int a){
        int t = parent[a];
        if (a == t) return a;
        find(t);
        weights[a] += weights[t];
        return parent[a] = find(parent[a]);
    }
    static void setWeight(int a, int b, long weight){
        int parentA = find(a);
        int parentB = find(b);
        if (b == parentB){
            parent[parentB] = parentA;
            weights[b] = weights[a] + weight;

        }
        else if (a== parentA){
            parent[parentA] = parentB;
            weights[a] = weights[b] - weight;
        }
        else if( parentA != parentB){
            long diff = weight +weights[a] - weights[b];
            parent[parentB] = parentA;
            weights[parentB] += diff;
        }
//        parent[parentB] = parentA;
//        weights[parentB] = weights[a]+weight-weights[b];


    }
    static long compare(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB)
            return Long.MAX_VALUE;
        return getWeight(b) - getWeight(a);
    }
    static long getWeight(int a){
        if (parent[a] == a) return weights[a];
        else{
            return getWeight(parent[a]) + weights[a];
        }
    }
}
