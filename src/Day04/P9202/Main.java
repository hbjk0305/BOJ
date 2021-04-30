package Day04.P9202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int W, N, score, max, cnt;
    static TrieNode root = new TrieNode();
    static char[][] board;
    static boolean[][] isVisit;
    static String maxString;
    static int[] dc ={-1,0,1,-1,1,-1,0,-1}, dr={-1,-1,-1,0,0,1,1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        W = Integer.parseInt(br.readLine());
        for (int i=0; i<W; i++){
            insert(br.readLine());
        }
//        System.out.println(root.toString("",0));
        br.readLine();
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            board = new char[4][4];
            isVisit = new boolean[4][4];
//            System.out.println("\tBOARD "+i);
            for (int r=0; r<4; r++){
                String line = br.readLine();
                if (line==null || line.length()==0) break;
                for (int c=0; c<4; c++){
                    board[r][c] = line.charAt(c);
                }
            }
//            printBoard();
            if (i!=N-1)
                br.readLine();
            score = 0;max = 0; maxString=""; cnt=0;
            for (int r=0; r<4; r++){
                for (int c=0; c<4; c++){
                    search(root, 0, r, c, "");
                }
            }
            sb.append(score +" "+maxString +" "+cnt+"\n");
            root.clearHit();
        }
        System.out.print(sb);

    }
    static void insert(String word){
        TrieNode current = root;
        for (int i=0; i<word.length(); i++){
            int wordIndex = word.charAt(i) -'A';
            if (current.children[wordIndex] == null){
                current.children[wordIndex] = new TrieNode();
            }
            current= current.children[wordIndex];
        }
        current.isEnd = true;
    }
    static boolean containsNode(String word){
        TrieNode current = root;
        for (int i=0; i<word.length(); i++){
            int wordIndex = word.charAt(i) -'A';
            if (current.children[wordIndex] == null){
                return false;
            }
            current= current.children[wordIndex];
        }
        return current.isEnd;
    }
    static void search(TrieNode current, int depth, int r, int c, String word){
//        1. 체크인
        isVisit[r][c] = true;
//        2. 목적지에 도착했는가?
        if (current.isEnd) {
            if (!current.isHit){
                current.isHit = true;
                cnt++;
                if (depth > max){
                    max = depth;
                    maxString = word;
                }
                else if (depth == max){
                    maxString = maxString.compareTo(word) < 0 ? maxString : word;
                }
//                System.out.println("FIND: "+word+"\tscore: "+depth2score(depth));
                score += depth2score(depth);
            }

        }
//        3. 연결된 곳을 순회
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                //            4. 갈 수 있는가?
                int DX = r+dr[i], DY = c+dc[j];
                if (canGo(DX, DY)){
                    int next = board[DX][DY]-'A';
                    if (current.children[next]!=null){
                        //              5. 간다
                        search(current.children[next], depth+1, DX, DY, word+board[DX][DY]);
                    }
                }
            }
        }
//        6. 체크아웃
        isVisit[r][c] = false;
    }
    static boolean canGo(int r, int c){
        if (r>=0 && r< 4 && c>=0 && c<4){
            return !isVisit[r][c];
        }
        return false;
    }
    static int depth2score(int depth){
        if (depth <=2) return 0;
        else if (depth ==3 || depth == 4) return 1;
        else if (depth==5) return 2;
        else if (depth == 6) return 3;
        else if (depth == 7) return 5;
        else return 11;
    }
    static void printBoard(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
}
class TrieNode{
    //부모가 나를 부르는 순간에 몇번째 인덱스인지 알면 데이터가 필요없다.
    TrieNode[] children = new TrieNode[26];
    boolean isEnd, isHit;   //isEnd는 단어의 끝을 의미. isHit는 이미 점수를 받았다는 뜻.

    public String toString(String current, int depth) {
        StringBuilder sb = new StringBuilder(current);
        sb.append(isEnd?".":"");
        for (int i=0; i<children.length; i++){
            if (children[i]!=null){
                sb.append('\n');
                for (int j=0; j<depth; j++){
                    sb.append("_");
                }
                sb.append(children[i].toString((char)('A'+i)+"", depth+1));
            }
        }
        return sb.toString();
    }
    boolean hasChild(char c){
        return children[c-'A'] != null;
    }
    TrieNode getChild(char c){
        return children[c-'A'];
    }
    void clearHit(){
        isHit = false;
        for (int i=0; i<children.length; i++){
            if (children[i] != null)
                children[i].clearHit();
        }
    }
}