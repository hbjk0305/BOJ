package Day03.P1202;
import java.util.*;
import java.io.*;
public class Main {
    static Jewelry[] jewelries;
    static int[] bags;
    static int n, k;
    static long sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bags = new int[k];
        jewelries = new Jewelry[n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i=0; i<k; i++){
            bags[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        PriorityQueue<Jewelry> queue = new PriorityQueue<>(Comparator.comparingInt(Jewelry::getValue).reversed());
        int index = 0;
        for (int i=0; i<k; i++){
//            System.out.println("Bag capacity: "+bags.get(i));
            for (; index<n ; index++){
                Jewelry tmp = jewelries[index];
                if (tmp.weight <= bags[i]){
//                    System.out.println("Push Jewrly: "+jewelries.get(index));
                    queue.add(tmp);

                }
                else{
                    break;
                }
            }
            if (!queue.isEmpty()) sum += queue.poll().value;

        }
        System.out.println(sum);
    }
}
class Jewelry{
    int weight;
    int value;
    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    @Override
    public String toString(){
        return String.format("weight: %d\tvalue: %d", weight, value);
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
