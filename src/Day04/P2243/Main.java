package Day04.P2243;
import java.util.*;
import java.io.*;
public class Main {
    static int n, s, max = 1000000;
    static long[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        s = 1;
        while (s < max){
            s*=2;
        }
        tree = new long[2*s];

        for (int i=0;i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 2){
                int c = Integer.parseInt(st.nextToken());
//                System.out.println("UPDATE "+b+" "+c);
                updateTree(1,1,max,b,c);
            }
            else if(a==1){
//                System.out.println("RANK "+b);
                int num = query(1,1,max,b);
                updateTree(1,1,max,num,-1);
                sb.append(num).append('\n');
            }
        }
        System.out.print(sb);
    }
    static void updateTree(int node, int left, int right, int index, long diff){
        if (left <= index && index <= right){
            tree[node] += diff;
            if (left!=right) {
                int mid = (left + right) / 2;
                updateTree(2 * node, left, mid, index, diff);
                updateTree(2 * node + 1, mid + 1, right, index, diff);
            }
        }
    }
    static int query(int node, int left, int right, long rank){
        if (left==right){
            return left;
        }
        int mid = (left+right)/2;
        long lvalue = tree[2*node];
        if (lvalue >= rank){    //왼쪽 자식의 값이 내가 원하는 랭크보다 크거나 같음.
            return query(2*node, left, mid, rank);
        }
        else {
            return query(2*node+1, mid+1, right, rank-lvalue);
        }
    }
}
