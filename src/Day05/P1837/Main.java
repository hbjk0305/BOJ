package Day05.P1837;

import java.util.*;

public class Main {
    static int k;
    static String p;
    static boolean[] isNotPrime;
    static List<Integer> primeList;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        p = sc.next();
        k = sc.nextInt();
        int maxN = 1000001;
        isNotPrime = new boolean[maxN];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        primeList = new ArrayList<>();
        for (int i=2; i<k; i++){
            if (!isNotPrime[i]){

                if (isDivided(i)){
                    System.out.println("BAD "+i);
                    return ;
                }
                for (int j= 2*i; j < maxN; j+=i){
                    isNotPrime[j] = true;
                }
            }
        }
        System.out.println("GOOD");
    }
    static boolean isDivided(int k){
        int tmp = 0;
        for (int i=0; i < p.length(); i++){
            int num = p.charAt(i)-'0';
//            System.out.print(num);
            tmp = (tmp*10+num)%k;
        }
//        System.out.println();
        return tmp==0;
    }
}
