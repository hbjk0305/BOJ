package Day10.P2449;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] bulbs;
    static int[][] dp;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bulbs = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<n; i++){
            bulbs[i] = Integer.parseInt(st.nextToken());
        }
    }
}
