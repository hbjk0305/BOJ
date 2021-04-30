package Day01.P1759;
import java.util.*;
public class Main {
    static int L, C;
    static List<Password> charList = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        for (int i=0; i<C; i++){
            charList.add(new Password(sc.next().charAt(0)));
        }
        Collections.sort(charList, new PasswordComparator());
        dfs(0, 0, 0, "", null);
    }
    public static void dfs(int index, int con, int vow, String result, Password last){
        if (index == L){
            if (con >= 2 && vow >= 1){
                System.out.println(result);
            }
        } else if (index < L){
            for (Password p : charList){
                if (p.isUsed == false){
                    String alph = Character.toString(p.alphabet);
                    p.isUsed = true;
                    if ("aieou".contains(alph)){
                        dfs(index+1, con, vow+1, result+alph, p);
                    }
                    else{
                        dfs(index+1, con, vow+1, result+alph, p);
                    }
                }
            }
        }
        if (last != null)
            last.isUsed = false;
    }
}
class Password{
    char alphabet;
    boolean isUsed;
    public Password(char alphabet){
        this.alphabet = alphabet;
        isUsed = false;
    }
}
class PasswordComparator implements Comparator<Password>{

    @Override
    public int compare(Password o1, Password o2) {
        return Character.compare(o1.alphabet, o2.alphabet);
    }
}
