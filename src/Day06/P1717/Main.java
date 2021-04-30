package Day06.P1717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cmd;
    static int[] pr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pr = new int[n+1];
        // Initialize
        for (int i=0; i<=n; i++)
            pr[i] = i;

        for (int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 0){
                unionf(a, b);
            } else{
                if (findf(a) == findf(b)){
                    sb.append("YES\n");
                } else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.print(sb);
    }
    static int findf(int a){
        // a의 부모가 누군지 알려준다.
        if (a==pr[a]) return a;
        return pr[a] = findf(pr[a]);
    }
    static void unionf(int a, int b){
        // a와 b를 합침.
        a = findf(a);
        b = findf(b);
        pr[a] = b;
    }
}

