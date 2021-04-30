package Day03.P11279;
import java.util.*;
public class Main {
    static int n, max_index =0;
    static int[] heap;
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        heap = new int[n+1];
        for (int i = 0;i <n; i++){
            int input = sc.nextInt();
            if (input == 0){
//                System.out.print("POP\t");
                System.out.println(pop());
            }
            else{
//                System.out.println("PUSH\t"+input);
                push(input);
            }
//            printHeap();
        }
    }
    public static void push(int num){
        heap[++max_index] = num;
        percolateUp(max_index);
    }
    public static void percolateUp(int index){
        if (index == 1) return;
        if (heap[index/2] < heap[index]){
            swap(index/2, index);
            percolateUp(index/2);
        }
        else return;
    }
    public static int pop(){
        if (max_index == 0){
            return 0;
        }
        int result = heap[1];
        heap[1] = heap[max_index--];
        percolateDown(1);
        return result;
    }
    public static void percolateDown(int index){
        if (!isValid_index(index)) return;
        int index1 = 2*index, index2 = 2*index+1;
        int min_index;
        if (!isValid_index(index1)) return ;
        if (!isValid_index(index2)) min_index = index1;
        else{
            min_index = heap[index1] > heap[index2] ? index1 : index2;
        }
        if (heap[min_index] > heap[index]){
            swap(index, min_index);
            percolateDown(min_index);
        }

    }
    public static void swap(int index1, int index2){
        if (index1 > max_index || index2 > max_index || index1 <1 || index2 < 1) return ;
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }
    public static void printHeap(){
        System.out.print("PRINT\t");
        for (int i = 1; i<= max_index; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    public static boolean isValid_index(int index){
        if (index < 1 || index > max_index) return false;
        return true;
    }
}
