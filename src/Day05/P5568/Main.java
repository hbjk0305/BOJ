package Day05.P5568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N, K, cnt;
    static boolean[] isVisited;
    static int[] nums;
    static Set<String> found = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        nums = new int[N];
        isVisited = new boolean[N];
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0; i<N; i++){
            solve(i, 1);
        }
//        for (String i: found){
//            System.out.print(i+" ");
//        }
//        System.out.println("\nANSWER");
        System.out.println(found.size());
    }
    static void solve(int index, int depth){
        //        1. 체크인
        isVisited[index] = true;
        sb.append(nums[index]);
//        2. 목적지에 도착했는가?
        if (depth == K && !found.contains(sb.toString())){
            found.add(sb.toString());
        }
//        3. 연결된 곳을 순회
        for (int i=0; i<N; i++) {
            //            4. 갈 수 있는가?
            if (!isVisited[i]) {
                //              5. 간다
                solve(i, depth + 1);
            }
        }
//        6. 체크아웃
        isVisited[index] = false;
        if (nums[index] >= 10){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}
