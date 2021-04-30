package Day03.P2042_IndexedTree;
import java.util.*;
import java.io.*;
public class Main {
    static int n, m, k, s;
    static long[] nums, tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new long[n+1];
        for (int i=1; i<=n; i++){
            nums[i] = Long.parseLong(br.readLine());
        }
//        System.out.println(Arrays.toString(nums));

        s = 1;
        while (s<n){
            s*=2;
        }
        tree = new long[2*s];
        makeTree(1,1,s); //s까지 업데이트해야 함!
        for (int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1){
                long diff = c - nums[b];
                nums[b] += diff;
                update(1, 1, s, b, diff);
            }
            else if (a == 2){
                System.out.println(query(1,1,s,b,c));
            }
        }
    }
    //Initialization (Top Down)
    static long makeTree(int node, int left, int right){
        if (left == right){ // leaf node
            if (left <= n){
                return tree[node] = nums[left];
            } else{
                return tree[node] = 0;
            }
        }
        int mid = (left+right)/2;
        tree[node] = makeTree(node*2, left, mid);   // left child;
        tree[node] += makeTree(node*2+1, mid+1, right);     //right child

        return tree[node];
    }
    //Initialization (Bottom Up)
    static void makeTree(){
        for (int i=0; i<n; i++){
            tree[s+i] = nums[i+1];
        }
        for (int i = s-1; i>0; i--){
            tree[i] = tree[i*2]+tree[i*2+1];
        }
    }
    //Query (Top Down)
    static long query(int node, int left, int right, int qLeft, int qRight){
        if (qRight < left || right < qLeft){    //Outside of Query
            return 0;
        } else if (qLeft <= left && right<=qRight) {    // Inside of Query
            return tree[node];
        }
        else{   //Intersect with Query
            int mid = (left+right)/2;
            return query(node*2, left, mid, qLeft, qRight) + query(node*2+1, mid+1, right, qLeft, qRight);
        }
    }
    // Bottom Up
    static long query(int left, int right){
        long result = 0;
        left += s-1;
        right += s-1;
        // s-1을 더해주면 리프노드로 이동.
        while (left <= right){
            if (left%2==1){
                //left가 홀수 -> 부모를 가르고 있음. 그래서 부모 쓰지 말고 자신의 값을 온전히 사용 -> 구간을 하나 줄임
                result += tree[left++];
            }
            if (right%2==0){
                //right가 짝수 -> 이 구간이 자기 부모에 걸쳐있다는 뜻임. -> 부모는 안 쓴다는 뜻. 그래서 현재 트리의 값을 온전히 사용 -> 그리고 구간을 하나 줄임.
                result += tree[right--];
            }
            left /= 2;
            right /= 2;
        }
        return result;
    }

    // Update (Top Down)
    static void update(int node, int left, int right, int index, long diff){
        if (left <= index && index <= right){    // index가 내가 관리하는 구간합 안인 경우만 업데이트
            tree[node] += diff;
            if (left!= right){  // if not leaf node
                int mid = (left+right)/2;
                update(node*2, left, mid, index, diff);
                update(node*2+1, mid+1, right, index, diff);
            }

        }
    }
    // Bottom Up
    static void update(int index, int value){
        index += s-1;
        tree[index] = value;
        index /= 2;
        while (index >= 1){
            tree[index] = tree[index*2]+tree[index*2+1];
            index /= 2;
        }
    }
}
