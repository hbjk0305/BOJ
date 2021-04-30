package Day02.P1806;
import java.util.*;
public class Main {
    static int n, m, result, sum, min=99999999;
    static Queue<Integer> queue, numQueue;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        queue = new LinkedList<>();
        numQueue = new LinkedList<>();
        for (int i=0; i<n; i++){
            numQueue.add(sc.nextInt());
        }

        while (true){
//            System.out.println(sum);
            if (sum >=m){
                if (queue.size() < min){
                    min = queue.size();
                }
                sum -= queue.poll();
            }
            else if (numQueue.isEmpty()){
                break;
            }
            else {
                int tmp = numQueue.poll();
                queue.add(tmp);
                sum += tmp;
            }
        }
        if (min == 99999999) System.out.println(0);
        else System.out.println(min);
    }
}
