package SamsungResearch.P13458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, B, C;
    static long ans;
    static long[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (long i: nums){
            ans += gamdok(i);
//            System.out.println(gamdok(i));
        }
        System.out.println(ans);

    }
    static long gamdok(long num){
        int ans = 1;
        num -= B;
        if (num <= 0) return ans;
        if (num%C == 0) return ans + num/C;
        return ans + num/C+1;
    }
}
