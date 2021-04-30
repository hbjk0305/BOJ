package Day03.P10828;
import java.util.*;
public class Main {
    static int n, index = -1;
    static int[] stack;
    static Command[] commandArr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        stack = new int[n+1];
        commandArr = new Command[n];
        for (int i=0; i<n; i++){
            String command = sc.next();
            if (command.equals("push")){
                commandArr[i] = new Command("push", sc.nextInt());
            }
            else{
                commandArr[i] = new Command(command, 0);
            }
        }
        for (int i = 0; i<n; i++){
            switch (commandArr[i].cmd){
                case "push":
                    int param = commandArr[i].param;
                    stack[++index] = param;
                    break;
                case "pop":
                    if (index >=0){
                        sb.append(stack[index--]).append('\n');
                    }else{
                        sb.append("-1").append('\n');
                    }
                    break;
                case "size":
                    sb.append(index+1).append('\n');
                    break;
                case "empty":
                    if (index >= 0){
                        sb.append("0").append('\n');
                    }
                    else{
                        sb.append("1").append('\n');
                    }
                    break;
                case "top":
                    if (index >= 0){
                        sb.append(stack[index]).append('\n');
                    }
                    else{
                        sb.append("-1").append('\n');
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
    static void printStack(){
        System.out.print("Print\t");
        for (int i=0; i<index; i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }

}
class Command{
    String cmd;
    int param;

    public Command(String cmd, int param) {
        this.cmd = cmd;
        this.param = param;
    }
}
