package Day03.P1655;
import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static PriorityQueue<Integer> minheap, maxheap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());
            if (maxheap.size() > minheap.size()){
                minheap.add(input);
            }
            else{
                maxheap.add(input);
            }
            if (maxheap.peek()!= null && minheap.peek()!=null){
                if (maxheap.peek() > minheap.peek()){
                    int max = maxheap.poll();
                    int min = minheap.poll();
                    maxheap.add(min);
                    minheap.add(max);
                }
            }
            sb.append(maxheap.peek()).append('\n');
        }

        System.out.print(sb);
    }
}
