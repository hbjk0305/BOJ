package Day09.P2342;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 99999999;
    static int ans, n;
    static int[][][] dp;
    static List<Integer> steps = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        steps.add(0);
        while (st.hasMoreTokens()){
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) break;
            steps.add(input);
        }
        n = steps.size()-1;
//        for (int i=1; i<=n; i++){
//            System.out.print(steps.get(i)+" ");
//        }
//        System.out.println();
        dp = new int[n+1][5][5];
        for (int i=0; i<=n; i++){
            for (int j=0; j<5; j++){
                for (int k=0; k<5; k++) {
                    dp[i][j][k] = MAX;   //[DDR 단계][왼발위치][오른발위치]일때까지 소모한 최소의 힘.
                }
            }
        }
        dp[0][0][0] = 0;
//        ans = calc(0, 0, 1);
//        System.out.println(ans);
        for (int i=0; i<n; i++){
            //i단계물의 결과를 잘 얻었다고 하자. i+1단계로 가고 싶다.
            // 내가 밟아야 할 DDR의 번호는 i+1이다.
            int nxt = steps.get(i+1);
            for (int l = 0; l<=4; l++){
                for (int r=0; r<=4; r++){
                    int now = dp[i][l][r];
//                    if (l== nxt){
////                        dp[i+1][nxt][r] = now + move(l, nxt);
//                        continue;
//                    }
//                    else if(r == nxt){
////                        dp[i+1][l][nxt] = now + move(r, nxt);
//                        continue;
//                    }
//                    else{
                        //왼발을 움직이자.
                    if (nxt != r) {
                        dp[i + 1][nxt][r] = Math.min(now + move(l, nxt), dp[i + 1][nxt][r]);
                    }
                        //오른발을 움직이자.
                    if (nxt != l) {
                        dp[i + 1][l][nxt] = Math.min(now + move(r, nxt), dp[i + 1][l][nxt]);
                    }
//                    }
                }
            }
        }
        ans = MAX;
        for (int l=0; l<5; l++){
            for (int r=0; r<5; r++){
                ans = Math.min(ans, dp[n][l][r]);
            }
        }
        System.out.println(ans);
    }
    public static int calc(int left, int right, int index){
        if (index >= steps.size()) return 0;
        if (dp[index][left][right] >= 0) return dp[index][left][right];
        int nxt = steps.get(index);
        if (nxt == left || nxt == right){
            return calc(left, right, index+1)+1;
        }
        else{
            int leftmove = calc(nxt, right, index+1) + move(left, nxt);
            int rightmove = calc(left, nxt, index+1) + move(right, nxt);
            return dp[index][left][right] = Math.min(leftmove, rightmove);

        }

    }
    static int move(int s, int e){
        if (s==0) return 2;
        else if (s==e) return 1;
        else if (Math.abs(s-e) == 2) return 4;
        else return 3;

    }

}
