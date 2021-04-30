package Day01.P3425;
import java.util.*;

class Command{
    String cmd;
    long param;
    public Command(String cmd, long param) {
        this.cmd = cmd;
        this.param = param;
    }
}
public class Main {
    static Stack<Long> goStack = new Stack<>();
    static List<Command> commands = new ArrayList<>();

    static boolean num(long param){
        if (param>=0 && param<=1000000000){
            goStack.push(param);
//            System.out.println("NUM: "+param);
            return true;
        }
        return false;
    }
    static boolean swp(){
        if (goStack.size()>=2){
            long first = goStack.pop();
            long second = goStack.pop();
            goStack.push(first);
            goStack.push(second);
//            System.out.println("SWP: "+first+" "+second);
            return true;
        }
        return false;
    }
    static boolean pop(){
        if (goStack.size()>=1){
            goStack.pop();
//            System.out.println("POP");
            return true;
        }
        return false;
    }
    static boolean inv(){
        if (goStack.size()>=1){
            goStack.push(-goStack.pop());
//            System.out.println("INV");
            return true;
        }
        return false;
    }
    static boolean dup(){
        if (goStack.size()>=1){
            goStack.push(goStack.peek());
//            System.out.println("DUP");
            return true;
        }
        return false;
    }
    static boolean add(){
        if (goStack.size()>=2){
            long first = goStack.pop();
            long second = goStack.pop();
            long result = first+second;

            if (Math.abs(result)>1000000000){
                return false;
            }
            goStack.push(result);
//            System.out.println("ADD: "+first+" "+second);
            return true;
        }
        return false;
    }
    static boolean mul(){
        if (goStack.size()>=2){
            long first = goStack.pop();
            long second = goStack.pop();

            long result = first*second;
            if (Math.abs(result)>1000000000){
                return false;
            }
            goStack.push(result);
//            System.out.println("MUL: "+first+" "+second);
            return true;
        }
        return false;
    }
    static boolean sub(){
        if (goStack.size()>=2){
            long first = goStack.pop();
            long second = goStack.pop();

            long result = second-first;
            if (Math.abs(result)>1000000000){
                return false;
            }
            goStack.push(result);
//            System.out.println("SUB: "+first+" "+second);
            return true;
        }
        return false;
    }
    static boolean div(){
        if (goStack.size()>=2){
            long first = goStack.pop();
            long second = goStack.pop();
            if (first == 0){
                return false;
            }
            long result = Math.abs(second)/Math.abs(first);
            if (Math.abs(result)>1000000000){
                return false;
            }
            if (first*second<0){
                result = -result;
            }
            goStack.push(result);
//            System.out.println("DIV: "+first+" "+second);
            return true;
        }
        return false;
    }
    static boolean mod(){
        if (goStack.size()>=2){
            long first = goStack.pop();
            long second = goStack.pop();
            if (first == 0){
                return false;
            }
            long result = Math.abs(second)%Math.abs(first);
            if (Math.abs(result)>1000000000){
                return false;
            }
            if (second<0){
                result = -result;
            }
            goStack.push(result);
//            System.out.println("MOD: "+first+" "+second);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            while (true) {
                String input = sc.next();
                if (input.equals("QUIT")) {
                    return;
                } else if (input.equals("END")) {
                    break;
                } else if (input.contains("NUM")) {
                        long num = sc.nextLong();
                        commands.add(new Command("NUM", num));
                } else {
                        commands.add(new Command(input, 0));
                }
            }
            int numLength = sc.nextInt();
            for (int i = 0; i < numLength; i++) {
                boolean success = true;
                long input = sc.nextLong();
                goStack.push(input);
                for (Command command : commands) {
                    if (success == false) {
                        break;
                    }
                    switch (command.cmd) {
                        case "ADD":
                            success = add();
                            break;
                        case "NUM":
                            success = num(command.param);
                            break;
                        case "MOD":
                            success = mod();
                            break;
                        case "DIV":
                            success = div();
                            break;
                        case "MUL":
                            success = mul();
                            break;
                        case "SUB":
                            success = sub();
                            break;
                        case "SWP":
                            success = swp();
                            break;
                        case "DUP":
                            success = dup();
                            break;
                        case "INV":
                            success = inv();
                            break;
                        case "POP":
                            success = pop();
                            break;
                    }
                }
                if (success == false || goStack.size() != 1) {
                    System.out.println("ERROR");
                } else {
                    System.out.println(goStack.pop());
                }
                goStack.clear();
            }
            commands.clear();
            System.out.println();
        }
    }
    //Error: stack에 2개가 없음. 결과가 10^9를 넘음.

}
