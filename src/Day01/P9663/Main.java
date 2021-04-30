package Day01.P9663;

import java.util.*;

public class Main {
    public static int[] arr;
    public static int N;	// 체스판의 크기
    public static int count = 0;


    public static void nQueen(int depth) {
        // 행을 다 체우면 카운트를 1 증가시키고 리턴시킨다.
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // Possibility() 해당 열에서 i 번째 행에 놓을 수 있는지를 검사하는 함수
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    public static boolean Possibility(int col) {

        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }

            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
             */
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
