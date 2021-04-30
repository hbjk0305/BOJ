package Day08.P11049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long ans;
    static Info[] mat;
    static int[][] dp;  //[i][j]: 행렬 i부터 행렬 j까지 연산한 최소의 겨과값.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mat = new Info[n+1];
        dp = new int[n+1][n+1];
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){
                dp[i][j] = -1;
            }
        }

        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            mat[i] = new Info(r, c);
        }
        System.out.println(calc(1, n));
//        System.out.println(dp[1][n]); //sol()함수를 쓰는 경우.
    }
    static int calc(int s, int e){
        if (e-s == 1){
            return mat[s].r*mat[s].c*mat[e].c;
        }
        if (e==s) return 0;
        //적절한 처리를 하여 계산량을 줄일 예정임.
        // clac(s, e)를 처음으로 계산한 적이 있으면 그때 계산했던 결과를 사용한다.
        if (dp[s][e] != -1){
            return dp[s][e];
        }
        //처음으로 계산을 하면 일단 계싼을 함.
        //부분으로 다 나워서 괜찮을 값을 구하는데...
        int mn=-1;
        for (int mid = s; mid<=e-1; mid++){
            int tmp = calc(s, mid)+calc(mid+1, e) + mat[s].r*mat[mid].c*mat[e].c;
            if (mn == -1 || tmp < mn) mn = tmp;
        }
//        처음으로 계산을 했기 때문에 계산결과를 저장한다.
        return dp[s][e] = mn;
    }
    static void sol2(){ //재귀를 사용하지 않는 방법.
        //이때는 초기화 빼야 함!
        int len;    //길이를 의미하는 변수
        for (len=2; len<=n; len++){
            for (int s =1; s+len-1 <= n; s++){   //s는 시작점.
                //dp[s][s+len-1]의 값을 구하고 싶다.
                int e = s+len -1, mn= -1;
                for (int mid = s; mid <= e-1; mid++){
                    int tmp = dp[s][mid]+dp[mid+1][e] +mat[s].r*mat[mid].c*mat[e].c;
                    if (mn == -1 || tmp < mn) mn = tmp;
                }
                dp[s][e] = mn;
            }

        }

    }

}
class Info{
    int r;
    int c;

    public Info(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
