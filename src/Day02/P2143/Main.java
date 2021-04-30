package Day02.P2143;
import java.util.*;
public class Main {
    static int n, m, T;
    static long cnt;
    static int[] arrayA, arrayB;
    static List<Integer> subA, subB;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        n = sc.nextInt();
        arrayA = new int[n];
        for (int i=0; i<n; i++){
            arrayA[i] = sc.nextInt();
        }
        m = sc.nextInt();
        arrayB = new int[m];
        for (int i=0; i<m; i++){
            arrayB[i] = sc.nextInt();
        }
        subA = new ArrayList<>();
        subB = new ArrayList<>();
        // 입력 끝.
        for (int i=0; i<n; i++){
            int sum = arrayA[i];
            subA.add(sum);
            for (int j=i+1; j<n; j++){
                sum += arrayA[j];
                if (sum > T) break;
                subA.add(sum);
            }
        }
        for (int i=0; i<m; i++){
            int sum = arrayB[i];
            subB.add(sum);
            for (int j=i+1; j<m; j++){
                sum += arrayB[j];
                if (sum > T) break;
                subB.add(sum);
            }
        }
        // subArray만들기.
        Collections.sort(subA);
        Collections.sort(subB);

        int low = 0, high = subB.size() - 1;

        // 투 포인터가 범위 벗어날때까지 계속
        while (low < subA.size() && high >= 0) {
            int add = subA.get(low) + subB.get(high);

            if (add < T) ++low;
            else if (add == T) {

                long a = 1, b = 1;
                while (low < subA.size() - 1 && subA.get(low) == subA.get(low+1)) {
                    ++low;
                    ++a;
                }
                while (high >= 1 && subB.get(high) == subB.get(high-1)) {
                    --high;
                    ++b;
                }
                cnt += a * b;
                ++low;
            }
            else --high;
        }

        System.out.println(cnt);
    }
}
