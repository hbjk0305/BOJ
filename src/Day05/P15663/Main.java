package Day05.P15663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] nums;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static Set<String> found = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        isUsed = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
    }
    static void search(int depth, int index){
        

    }
}
