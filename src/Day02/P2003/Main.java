package Day02.P2003;
import java.util.*;
public class Main {
    static int n, m, result, sum;
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
            if (sum == m){
                result++;
            }
        }
        System.out.println(result);
    }
}
