package Day03.P1275;

import java.io.*;
import java.util.*;
public class Main {
    static int n, q, s;
    static long[] tree, nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        nums = new long[n+1];
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }
        s = 1;
        while (s < n){
            s*=2;
        }
        tree = new long[2*s];
        makeTree(1, 1, s);
        for (int i=0; i<q; i++){

        }
        System.out.print(sb);

    }
    public static long makeTree(int node, int left, int right){
        if (left == right){
            if (left <= n) return tree[node] = nums[left];
            else return tree[node] = 0;
        }
        else{
            int mid = (left+right)/2;
            return tree[node] = makeTree(2*node, left, mid) + makeTree(2*node+1, mid+1, right);
        }
    }
    public static void update(int node, int left, int right, int index, long diff){
        if (left <= index && index <= right){
            tree[node] += diff;
            if (left != right){
                int mid = (left+right)/2;
                update(node*2, left, mid, index, diff);
                update(node*2+1, mid+1, right, index, diff);
            }
        }
    }
    public static long query(int node, int left, int right, int qLeft, int qRight){
        if (qRight < left || right < qLeft) return 0;
        else if (qLeft <= left && right <= qRight){
            return tree[node];
        }
        else{
            int mid = (left+right)/2;
            return query(2*node, left, mid, qLeft, qRight) + query(2*node+1, mid+1, right, qLeft, qRight);
        }
    }
}
