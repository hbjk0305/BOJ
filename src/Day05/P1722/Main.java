package Day05.P1722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, type;
    static long rank;
    static int[] nums;
    static long[] factorial;
    static boolean[] isUsed;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        factorial = new long[n+1];
        nums = new int[n+1];
        isUsed = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        type = Integer.parseInt(st.nextToken());
        if (type==1){
            rank = Long.parseLong(st.nextToken());
            search(1, rank);
        }
        else{
            long sum = 1;
            for (int i=1; i<=n; i++){
                int tmp =  Integer.parseInt(st.nextToken());
                isUsed[tmp] = true;
                sum += cnt(tmp) * factorial(n-i);
            }
            System.out.println(sum);
        }
    }
    static long factorial(int n){
        if (n==1 || n==0) return factorial[n] = 1;
        if (factorial[n]!=0) return factorial[n];
        return factorial[n] = n*factorial(n-1);
    }
    static void search(int depth, long rank){
        if (depth > n){
            printnums();
            return;
        }
        long fac = factorial(n-depth);
        for (int i=1; i<=n; i++){
            if (isUsed[i]) continue;
            if (rank <= fac){
                nums[depth] = i;
                isUsed[i] = true;
                search(depth+1, rank);
                return ;
            }
            rank -= fac;
        }
        nums[depth] = n;
        isUsed[n] = true;
        search(depth+1, rank);
        return ;
    }
    static void printnums(){
        StringBuilder sb= new StringBuilder();
        for (int i=1; i<nums.length; i++){
            sb.append(nums[i]).append(' ');
        }
        System.out.println(sb);

    }
    static int cnt(int n){
        int cnt = 0;
        for (int i=1; i<n; i++){
            if (!isUsed[i]) cnt++;
        }
        return cnt;
    }
}
