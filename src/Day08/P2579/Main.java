package Day08.P2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] step;
    static long[][] sum;
    static boolean[] isSeq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        sum = new long[2][n+10]; //0번 줄은 이전계단 값을 사용. 1번 줄은 2칸 전 계단 값을 사용.
        step = new int[n+10];
        isSeq = new boolean[n+1];
        for (int i=1; i<=n; i++){
            step[i] = Integer.parseInt(br.readLine());
        }
        sum[0][1] = step[1];
        for (int i=2; i<=n; i++){
//            printsum();
            sum[1][i] = Math.max(sum[0][i-2], sum[1][i-2])+step[i];
            if (sum[0][i-1] < sum[1][i-1] || sum[0][i] == -1){
                sum[0][i] = sum[1][i-1] + step[i];
                sum[0][i+1] = -1;
            }
            else{
                sum[0][i] = sum[0][i-1] + step[i];
                sum[0][i+1] = -1;
            }

        }
//        printsum();
        System.out.println(Math.max(sum[0][n], sum[1][n]));

    }
    static void printsum(){
        for (int i=0; i< 2; i++){
            for (int j=1; j<=n; j++){
                System.out.print(sum[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
