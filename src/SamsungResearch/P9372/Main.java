package SamsungResearch.P9372;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int T, n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int i=0; i<m; i++){
                br.readLine();
                continue;
            }   // 네트워크 입력 완료(왕복)
            sb.append(n-1).append("\n");
        }
        System.out.println(sb);
    }
}
