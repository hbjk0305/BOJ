package Day10.P1102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF  = 99999999;
    static int n, p, start;
    static int[][] cost = new int[16][16];
    static int[] dp= new int[(1<<16)+1];    //dp[i]: i상태를 만들기 위한 최소비용. i는 비트.
    static boolean[] onoff;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<=(1<<16); i++){
            dp[i] = INF;
        }
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String init = br.readLine();
        for (int i=0; i<init.length(); i++){
            if (init.charAt(i) == 'Y'){
//                onoff[i] = true;
                start = setbit(start, i);
            }
        }
        p = Integer.parseInt(br.readLine());
        //입력 끝.

        dp[start] = 0;
//        System.out.println(start);
        for (int state = 0; state<(1<<n); state++) {
            // 작은거부터 큰거로 하자. 이전꺼는 완료되었다는 확신이 있음.
            for (int i = 0; i < n; i++) {
                //state인 상태에서 i발전소를 킬 수 있을까?
                //켜면 비용은 어떻게 될까?
                //그때의 state는 어떤 모양일까? <- nxt_state
                //nxt_state는 어떤 값이 있을까?
                int nxt_state, nxt_cost;
                if (chkbit(state, i)) continue; //i가 이미 켜져 있음.
                nxt_state = setbit(state, i);
                for (int j = 0; j<n; j++){
                    //j번째 발전소를 이용하여 i를 켜자!
                    if (!chkbit(state, j)) continue;    //j가 켜져 있지 않으면 skip
                    nxt_cost = dp[state] + cost[j][i];
                    dp[nxt_state] = Math.min(dp[nxt_state], nxt_cost);

                }
            }
        }
//        for (int i=0; i<=(1<<n); i++){
//            System.out.print(dp[i]+" ");
//        }
//        System.out.println();
        int ans = INF;
        for (int i=0; i<=(1<<n); i++){
            if (bitcount(i)>=p){
                //작업.
                ans = Math.min(ans, dp[i]);
            }
        }
        if (ans == INF){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }

    }
    static int setbit(int org, int pos){
        return org | (1<<pos);
    }
    static int unsetbit(int org, int pos){
        return org & (~(1<<pos));
    }
    static boolean chkbit(int org, int pos){
        if ((org & (1<<pos)) == 0) return false;
        return true;
    }
    static int bitcount(int x){
        int cnt = 0;
        while (x != 0){
            if ((x&1) != 0) cnt++;
            x = x>>1;
        }
        return cnt;
    }

}
