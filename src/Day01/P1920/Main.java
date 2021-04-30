package Day01.P1920;

import java.util.*;

public class Main {
    static List<Integer> givenList = new ArrayList<>();
    static int n, m;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i<n; i++){
            givenList.add(sc.nextInt());
        }
        Collections.sort(givenList);
        int m = sc.nextInt();
        for (int i = 0; i<m; i++){
            int index = Collections.binarySearch(givenList, sc.nextInt());
            if (index < 0 ){
                System.out.println(0);
            }
            else{
                System.out.println(1);
            }
        }

    }

}
