package Day03.P2504;
import java.util.*;
public class Main {
    static int result;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
//        str = str.replaceAll("\\(\\)", "2");
//        str = str.replaceAll("\\[\\]", "3");
//        System.out.println(str);
        Stack<Element> stack = new Stack<>();
        for (int i = 0; i<input.length(); i++){
            char command = input.charAt(i);
            if (command == '(' || command == '['){
                stack.push(new Element(command));
            }else if(command == ')'){
                int sum = 0;
                boolean isInvalid = true;
                while (!stack.isEmpty()){
                    Element ele = stack.pop();
                    if (ele.isValue) { //숫자
                        sum += ele.value;
                    }
                    else if (ele.command=='('){
                        if (sum == 0){
                            stack.push(new Element(2));
                        } else{
                            stack.push(new Element(sum*2));
                        }
                        isInvalid = false;
                        break;
                    }
                    else{
                        isInvalid = true;
                        break;
                    }
                }
                if (isInvalid){
                    System.out.println(0);
                    return ;
                }

            }else if(command == ']'){
                int sum = 0;
                boolean isInvalid = true;
                while (!stack.isEmpty()){
                    Element ele = stack.pop();
                    if (ele.isValue) { //숫자
                        sum += ele.value;
                    }
                    else if (ele.command=='['){
                        if (sum == 0){
                            stack.push(new Element(3));
                        } else{
                            stack.push(new Element(sum*3));
                        }
                        isInvalid = false;
                        break;
                    }
                    else{
                        isInvalid = true;
                        break;
                    }
                }
                if (isInvalid){
                    System.out.println(0);
                    return ;
                }
            }
        }
        int sum=0;
        while (!stack.isEmpty()){
            Element e = stack.pop();
            if (!e.isValue){
                System.out.println(0);
                return ;
            }
            else{
                sum += e.value;
            }
        }
        System.out.println(sum);
    }
}
class Element{
    boolean isValue;
    int value;
    char command;

    public Element(int value) {
        this.value = value;
        isValue = true;
    }

    public Element(char command) {
        this.command = command;
        isValue = false;
    }
}
