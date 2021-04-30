package Day06.P1922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m, cnt, sum;
    static int[] pr;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pr = new int[n+1];
        for (int i=1; i<=n; i++){
            pr[i] = i;
        }
        m = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(new weightComparator());
        for (int i=0; i<m; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while (!pq.isEmpty()){
            Edge e = pq.poll();
//            System.out.println(e);
            if (findf(e.start) != findf(e.end)){ //다른 집합이면,
                //연결.
                unionf(e.start, e.end);
                sum += e.weight;
                cnt++;
            }
            if (cnt == n-1){
                break;
            }
        }
        System.out.println(sum);

    }
    static int findf(int a){
        if (pr[a] == a) return a;
        return pr[a] = findf(pr[a]);
    }
    static void unionf(int a, int b){
        a = findf(a);
        b = findf(b);
        pr[a] = b;
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

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
class weightComparator implements Comparator<Edge>{

    @Override
    public int compare(Edge o1, Edge o2) {
        return Integer.compare(o1.weight, o2.weight);
    }
}
