package Day09.P2098;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] dp = new int[1<<16][16];  //dp[선택한 도시들][마지막에 여행한 도시]
    //시작점으로 다시와야 하다는 점!
    // 0 0 0 0 0 1 1 0 0: 선택한 도시를 1로 둠. 즉 3, 4번 도시만을 선택했다는 뜻.
    // ex) int x; x|=(1<<10);   // 그러면 10번째 도시가 방문 처리 된다.
    // ex) int x; x& (1<<10);   //check
    //unmask
    static final int INF = 999999999;
    static int[][] W;
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        W = new int[n][n];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                int tmp = Integer.parseInt(st.nextToken());
//                if (tmp == 0) tmp = INF;
                W[i][j] = tmp;
            }
        }
        //입력 끝.
        for (int i=0; i<(1<<16); i++){
            for (int j=0; j<16; j++){
                dp[i][j] = INF;
            }
        }
        dp[1][0] = 0;   // 0번 도시(비트로 나타내면 1)를 시작점으로 셋팅.
        //dp배열 초기화

        for (int i=0; i<(1<<n); i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++){
//                    k로 갈 수 있는지 확인
                    if (bit_chk(i, k)) continue;
                    if (W[j][k]==0) continue;
                    int nxt = bit_set(i, k);
                    dp[nxt][k] = Math.min(dp[nxt][k], dp[i][j]+W[j][k]);
                }
            }
        }

        int ans = INF;
        int last_state = (1<<n)-1;  // 모든 도시를 방문한 상태이고,
        //모든 도시를 순회했고, 시작으로 돌아와야 한다.
        // 비용을 구하면서, 정답을 찾는다.
        for (int i=0; i<n; i++){
            if (W[i][0] == 0) continue; //길이 없음.
            int tmp = dp[last_state][i]+W[i][0];
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);


    }
    static int bit_set(int origbit, int pos){
//        pos번째 비트를 세팅함. 가장 낮은 자리수가 0
        return origbit | (1<< pos);
    }
    static int bit_unset(int origbit, int pos){
        return origbit & (~(1<<pos));
    }
    static boolean bit_chk(int origbit, int pos){
        if((origbit & (1<<pos)) == 0) return false;
        return true;
    }
}
