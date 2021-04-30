package Day05.P13251;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, k, n;
    static int[] nums;
    static long[][] combination;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[m];
        for (int i=0; i<m; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            n += nums[i];
        }
        combination = new long[n+1][n+1];
        k = Integer.parseInt(br.readLine());

        double prob = 0.0;
        for (int i=0; i<m; i++){
            if (nums[i] < k)
                continue;
            double ratio = 1.0;
            for (int j=0; j<k; j++){
                ratio *= (nums[i]-j)/(double) (n-j);
            }
            prob += ratio;
        }

        System.out.println(prob);

    }
    static long combination(int n, int k){
        if (k==1) return combination[n][k] = n;
        if (n == k || k == 0) return combination[n][k] = 1;
        if (combination[n][k] != 0){
            return combination[n][k];
        }
        else return combination[n][k] = (combination(n-1, k-1)+combination(n-1, k)) > 1000000000 ? 1000000000 : (combination(n-1, k-1)+combination(n-1, k));
    }
    static long gcd(long a, long b){
        return b==0? a:gcd(b, a%b);
    }
}
