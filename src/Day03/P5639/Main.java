package Day03.P5639;
import java.io.*;
import java.util.*;
public class Main {
    static Node root;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = br.readLine();
            if (input == null || input.length() == 0) break;
            int num = Integer.parseInt(input);
            if (root == null){
                root = new Node(num);
            }
            else{
                root.insert(num);
            }
        }
        root.post_travel();

    }
}
class Node{
    int num;
    Node left;
    Node right;
    public Node(int num) {
        this.num = num;
    }
    public void insert(int n){
        if (n < num){
            if (left == null) {
                left = new Node(n);
            }
            else{
                left.insert(n);
            }
        }
        else if (n > num){
            if (right == null){
                right = new Node(n);
            }
            else{
                right.insert(n);
            }
        }
    }
    public void post_travel(){
        if (left != null) left.post_travel();
        if (right != null) right.post_travel();
        System.out.println(num);

    }
}

