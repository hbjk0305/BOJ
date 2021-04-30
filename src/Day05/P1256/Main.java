package Day05.P1256;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long K;
    static StringBuilder sb;
    static long[][] combination = new long[201][201];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (combination(N+M, N) < K){
            System.out.println(-1);
            return ;
        }
        search(N, M, K);
        System.out.println(sb);

    }
    static void search(int n, int m, long rank){

        if (n==0 && m==0){
            return ;
        }
        if (n==0){
            sb.append("z");
            search(n, m-1, rank);
            return ;
        }
        else if(m==0){
            sb.append("a");
            search(n-1, m, rank);
            return ;
        }
        long before = combination(n+m-1, m);
        if (before < rank){
            sb.append("z");
            search(n, m-1, rank - before);
        }
        else{
            sb.append("a");
            search(n-1, m, rank);
        }

    }
    static long combination(int n, int k){
        if (k==1) return combination[n][k] = n;
        if (n == k || k == 0) return combination[n][k] = 1;
        if (combination[n][k] != 0){
            return combination[n][k];
        }
        else return combination[n][k] = (combination(n-1, k-1)+combination(n-1, k)) > 1000000000 ? 1000000000 : (combination(n-1, k-1)+combination(n-1, k));
    }
}
