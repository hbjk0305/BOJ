package Day05.P14476;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, S = 1;
    static long[] nums, tree;

    static long gcd(long a, long b){
        return b==0? a : gcd(b, a%b);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }
        while (S < n){
            S *= 2;
        }
        tree = new long[2*S];
        makeTree(1,1,S);
//        printTree();
        long max_gcd = 0, delete = 0;
        for (int i=1; i<=n; i++){
//            System.out.println("Update "+i+"th Number to 0");
            updateTree(i, 0);
//            printTree();
            long gcd = tree[1];
            if (nums[i]%gcd != 0 && gcd > max_gcd){
                max_gcd = gcd;
                delete = nums[i];
            }
            updateTree(i, nums[i]);
        }
        if (max_gcd == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(max_gcd +" " + delete);
        }
    }
    static long makeTree(int node, int left, int right){
        if (left == right){
            if (left <= n){
                return tree[node] = nums[left];
            }
            else{
                return tree[node] = 0;
            }
        }
        else{
            int mid = (left+right) / 2;
            return tree[node] = gcd(makeTree(2*node, left, mid), makeTree(2*node+1, mid+1, right));
        }
    }
    static void updateTree(int index, long newValue){
        index += S-1;
        tree[index] = newValue;
        index /= 2;
        while (index >= 1){
            tree[index] = gcd(tree[2*index], tree[2*index+1]);
            index /= 2;
        }
    }
    static void printTree(){
        for (int i = 1; i< tree.length; i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
    }

}
