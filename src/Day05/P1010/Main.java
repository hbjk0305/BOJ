package Day05.P1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, n, m;
    static long[][] cases;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        cases = new long[31][31];
        for (int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            System.out.println(combination(n, m));
        }
    }

    static long combination(int n, int m){
        if (m  < n) return 0;
        if (m == n) return cases[n][m] = 1;
        if (n == 1) return cases[n][m] = m;
        if (cases[n][m] != 0) return cases[n][m];
        else {
            for (int i=1; i<=m-n+1; i++)
                cases[n][m] += combination(n-1, m-i);
            return cases[n][m];
        }

    }
}
