package Day03.P10845;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
public class Main {
    static int n, front, back;
    static int[] queue;
    static List<Command> commands;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        queue = new int[n];
        commands = new ArrayList<>();
        for (int i=0; i < n; i++){
            String input = sc.next();
            if (input.equals("push")){
                commands.add(new Command("push", sc.nextInt()));
            }
            else{
                commands.add(new Command(input, 0));
            }
        }
        for (Command c: commands){
            String cmd = c.cmd;
            switch (cmd){
                case "push":
                    c.push();
                    break;
                case "pop":
                    sb.append(c.pop()).append('\n');
                    break;
                case "size":
                    sb.append(c.size()).append('\n');
                    break;
                case "empty":
                    sb.append(c.empty()).append('\n');
                    break;
                case "front":
                    sb.append(c.front()).append('\n');
                    break;
                case "back":
                    sb.append(c.back()).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
    static class Command{
        String cmd;
        int param;
        public Command(String cmd, int param) {
            this.cmd = cmd;
            this.param = param;
        }
        private void push(){
            queue[back++] = param;
            back = (back+n)%n;
        }
        private int pop(){
            if (empty()==1) return -1;
            int tmp = queue[front++];
            front = (front+n)%n;
            return tmp;

        }
        private int size(){
            return (back-front+n)%n;
        }
        private int empty(){
            if (front == back){
                return 1;
            }
            return 0;
        }
        private int front(){
            if (empty()==1) return -1;
            return queue[front];
        }
        private int back(){
            if (empty()==1) return -1;
            return queue[back-1];
        }
    }
}
