package Day08.P11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        sum = new int[n+1];
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        }
//        for (int i=1; i<=n; i++){
//            System.out.print(sum[i]+" ");
//        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end]-sum[start-1]).append('\n');
        }
        System.out.print(sb);
    }
}
