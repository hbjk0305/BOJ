package Day02.P2805;

import java.io.*;
import java.util.*;

public class Main {
    static long  sum;
    static int n, m, height;
    static int[] trees;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //빠르지만 line단위로 읽어옴.
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line); //띄어쓰기 기준으로 토큰을 잘라준다.
        n = Integer.parseInt(st.nextToken()); //String 단위로 토큰이 넘어온다.
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new int[n];
        for (int i = 0; i <n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            trees[i] = tmp;
        }
        Arrays.sort(trees);
        int low = 0, high = n-1, ans = -1;
        for (int i: trees){
            System.out.print(i+" ");
        }
        System.out.println();
        while (low <= high){
            int mid = (trees[low]+trees[high])/2, sum = 0, mid_index=-1;
            System.out.print("low: "+low+"\thigh: "+high+"\tmid: "+mid);
            boolean flag = false;
            for (int i=low; i< high; i++){
                int tmp = trees[i]-mid;
                if (tmp >= 0){
                    if (!flag){
                        mid_index = i;
                        flag = true;
                    }
                    sum += tmp;
                }
            }
            System.out.println("\tsum: "+sum+"\tmid_index: "+mid_index);
            if (sum == m){
                ans = mid;
                break;
            }
            else if (sum > m){
                high = mid_index;
            }
            else{
                low = mid_index;
                ans = mid;
            }
        }
        System.out.println(ans);

    }
}
