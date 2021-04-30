package Day09.P11062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n, SUM;
    static int[] cards, subsum;
    static int[][] kdp, mdp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            SUM = 0;
            n = Integer.parseInt(br.readLine());
            init();
//            subsum = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++){
                cards[i] = Integer.parseInt(st.nextToken());
                SUM += cards[i];
//                subsum[i] = subsum[i-1]+cards[i];   // subsum[i]: 1~i까지의 합.
            }


            sb.append(keunwoo(1, n, SUM)).append('\n');
        }
        System.out.print(sb);
    }
    static int keunwoo(int s, int e, int sum){
        // 근우가 s나 e중 하나를 선택하자.
        if (s==e) return cards[s];
        if (kdp[s][e] >= 0) return kdp[s][e];
        int selectS = myungwoo(s+1, e, sum-cards[s]);   //근우가 s를 선택했을 때, 명우가 얻는 최대 점수.
//        int left = cards[s] + subsum[e]-subsum[s]-myungwoo(s+1, e);
        int selectE = myungwoo(s, e-1, sum-cards[e]);
//        int right = cards[e]+subsum[e-1]-subsum[s-1]-myungwoo(s, e-1);
        if (selectE < selectS){
            kdp[s][e] = sum - selectE;
        }
        else{
            kdp[s][e] = sum - selectS;
        }
        return kdp[s][e];

    }
    static int myungwoo(int s, int e, int sum){
        if (s==e) return cards[s];
        if (mdp[s][e] >= 0) return mdp[s][e];
        int selectS = keunwoo(s+1, e, sum-cards[s]);
        int selectE = keunwoo(s, e-1, sum-cards[e]);
        if (selectE < selectS){
            mdp[s][e] = sum - selectE;
        }
        else{
            mdp[s][e] = sum - selectS;
        }
        return mdp[s][e];

    }
    static void init(){
        cards = new int[n+1];
        kdp = new int[n+1][n+1];
        mdp = new int[n+1][n+1];
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){
                kdp[i][j] = mdp[i][j] = -1;
            }
        }
    }
}
