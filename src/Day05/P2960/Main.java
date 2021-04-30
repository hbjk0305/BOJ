package Day05.P2960;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, cnt;
    static boolean[] notPrime;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        notPrime = new boolean[n+1];
        for (int i=2; i <n+1; i++){
            if (!notPrime[i]){
//                System.out.println("Let's Remove "+i);
                for (int j=i; j < n+1; j+=i){
//                    System.out.println("Now "+j + notPrime[j]);
                    if (!notPrime[j]) {
                        notPrime[j] = true;
//                        System.out.println(j);
                        cnt++;
                        if (cnt == k) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
