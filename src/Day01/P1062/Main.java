package Day01.P1062;
import java.io.FileInputStream;
import java.util.*;

public class Main {
    static boolean[] visited;
    static String[] words;
    static int n, k, selectedCount=0, max=0;
    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("./input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt()-5;

        words = new String[n];
        visited = new boolean[26];
        //a, n, t, i, c 는 필수로 알고 있어야 함.
        visited['a'-'a'] = visited['n'-'a'] = visited['t'-'a'] = visited['i'-'a'] = visited['c'-'a'] = true;

        for (int i=0; i<n; i++){
            String str = sc.next();
            words[i] = str.substring(4, str.length()-4 );
        }
        // 입력 끝

        if (k < 0){
            System.out.println(0);
            return ;
        }
        if (k==21){
            System.out.println(n);
            return ;
        }
        if (k==0){
            System.out.println(knownWordNum());
            return ;
        }

        for (int i=0; i<26; i++){
            if (visited[i] == false){
                dfs(i);
            }
        }
        System.out.println(max);
    }
    static void printKnown(){
        System.out.print("I Know: ");
        for (int i=0; i<26; i++){
            if (visited[i]){
                System.out.print((char)(i+'a')+" ");
            }
        }
    }
    static boolean isKnown(String word){
        for (int i = 0; i < word.length(); i++){
            if (!visited[word.charAt(i)-'a']){
                return false;
            }
        }
        return true;
    }
    static int knownWordNum(){
//        printKnown();
        int num=0;
        for (String word: words){
            if (isKnown(word)) {
//                System.out.print("\t"+word);
                num++;
            }
        }
//        System.out.println("\t"+num);
        return num;
    }
    static void dfs(int index){
//         1. check-in -> visited 체크, selectedCount++
        visited[index] = true;
        selectedCount++;
//         2. 목적지인가? selected Count가 k에 도달했는가? -> max 갱신
        if (selectedCount == k){
            int known = knownWordNum();
            if (max < known)
                max = known;
        }
        else if (selectedCount < k){
//              3. 연결된 곳을 순회 index+1~26
            for (int i = index + 1; i < 26; i++) {
//                  4. 갈 수 있는가? visited[next] == false
                if (visited[i] == false) {
//                        5. 간다 ->dfs(next)
                    dfs(i);
                }
            }
        }
//            6. 체크아웃 -> visited[index]  = false, selectedCount--;
        visited[index] = false;
        selectedCount--;
    }
}
