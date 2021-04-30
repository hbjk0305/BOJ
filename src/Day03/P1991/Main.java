package Day03.P1991;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n;
    static Node[] tree = new Node[27];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            Node node = new Node(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
            tree[node.name-'A'] = node;
        }
        preTravel(0);
        sb.append('\n');
        inTravel(0);
        sb.append('\n');
        postTravel(0);
        System.out.println(sb);

    }
    public static void preTravel(int index){
        if (index == '.'-'A'){
            return ;
        }
        sb.append(tree[index].name);
        preTravel(tree[index].left-'A');
        preTravel(tree[index].right-'A');
    }
    public static void inTravel(int index){
        if (index == '.'-'A'){
            return ;
        }

        inTravel(tree[index].left-'A');
        sb.append(tree[index].name);
        inTravel(tree[index].right-'A');
    }
    public static void postTravel(int index){
        if (index == '.'-'A'){
            return ;
        }

        postTravel(tree[index].left-'A');
        postTravel(tree[index].right-'A');
        sb.append(tree[index].name);
    }
}

class Node{
    char name;
    char left;
    char right;
    public Node(char name, char left, char right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }
}
