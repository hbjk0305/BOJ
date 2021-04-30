package Day09.P7579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] costs, mems;
    static int[] dp = new int[10001];   // cost [i]를 소모하여 얻을 수 있는 최대 메모리 크기.
    static int[][] new_dp = new int[101][10001];    //[j][i]: j까지 app을 살펴봤을 때, cost i로 얻을 수 있는 최대 메모리 크기.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        costs = new int[n+1];
        mems = new int[n+1];
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            mems[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
//            for (int j=0; j+costs[i]<=10000; j++){
//                //뭔가 계산 -> 실패
//                if (dp[j+costs[i]] < dp[j]+mems[i])
//                    dp[j+costs[i]] = dp[j]+mems[i];
//            }
        }
/*
19 20169
240 2560 434 6 31 577 500 2715 2916 952 2490 258 1983 1576 3460 933 1660 2804 2584
82 77 81 0 36 6 53 78 49 82 82 33 66 8 60 0 98 91 93
답이 484 나와야 함.
 */

        //app 하나만 지우는 처리를 위해 코드 변형.
        for (int j=1; j<=n; j++){
            for (int i=0; i<=10000; i++){
                new_dp[j][i] = new_dp[j-1][i];  //j번째 앱을 사용하지 않았을 때.
                if (i-costs[j] >= 0){//j번째 앱 사용하지 않은 경우와 사용한 경우 중 큰 것 선택.
                    new_dp[j][i] = Math.max(new_dp[j-1][i], new_dp[j-1][i-costs[j]]+mems[j]);
                }

            }
        }
        //비용을 찾아보면서 m이상의 메모리를 확보했는지 확인.
        int ans = -1;
        for (int i=0; i<=10000; i++){
            if (new_dp[n][i] >= m){
                ans = i;
                break;
            }
//            System.out.print(dp[i]+" ");
        }
        System.out.println(ans);



    }
}
