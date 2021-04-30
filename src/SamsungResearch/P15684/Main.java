package SamsungResearch.P15684;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, ans=9999999;
    static int[] nums;
    static boolean[][] ladder;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        ladder = new boolean[H+1][N+1];
        reset();
        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            System.out.println(ladder[a][b]);
            ladder[a][b] = true;
        }
        solve(1, 1,0);
        if (ans == 9999999){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
//        printArr(nums);
//        swap(nums,1,2);
//        printArr(nums);

    }
    static void solve(int row, int col, int cnt){
        if (cnt>=4 || ans <= cnt) return ;
        if (chk()){
            ans = cnt;
            return ;
        }
        for (int i=row; i<=H; i++) {
            for (int j = col; j < N; j++) {
                if (!ladder[i][j - 1] && !ladder[i][j + 1] && !ladder[i][j]) {
                    ladder[i][j] = true;
                    solve(i, 1,cnt + 1);    //col=j로 두면 안풀림ㅠㅠ 왤까.
                    ladder[i][j] = false;
                }
            }
        }
    }
    static boolean chk() {
        for (int i=1; i<=H; i++){
            for (int j=1; j<N; j++){
                if (ladder[i][j]){
                    swap(nums, j, j+1);
                }
            }
        }
        boolean flag = true;
        for (int i=1; i<=N; i++){
            if (nums[i]!=i) {
                flag = false;
                break;
            }
        }
        reset();
        return flag;
    }
    static void reset(){
        for (int i=0; i<=N;i ++) {
            nums[i] = i;
        }
    }
    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static void printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i : arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
