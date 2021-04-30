package Day05.P3955;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {

//        X: 인당 나눠줄 사탕의 수
//        Y: 사탕 봉지의 수

//        A * x + 1 = B * y
//        Ax+By=C형태로 변환
//        -Ax+By=1
//        A(-x)+By=1

//         A, B 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//        D = gcd(A,B)
//        D*k=C ==> C%D==0이어야만 해를 개질 수 있다. : 배주항등식
//        확장 유클리드 호제법을 이용하여 s, t, r = D를 찾아낼 수 있다.
            int[] result = eGCD(a,b);
            if (result[2] != 1){ //r!=1
                System.out.println("IMPOSSIBLE");
            }
            else {

//        x0 = s * C/D
//        y0 = t * C/D
                int x0 = result[0];
                int y0 = result[1];
//        일반해공식(부호주의, 바뀌어도 상관은 없지만 둘의 부호가 다르다!!)
//        x = x0+B/D*k
//        y = y0 -A/D*k

//        x<0
//        x0+ B/D*k < 0
//        k < -x0/B*D

//        0<y<=1e9
//        0<y0-A/D*k<=1e9
//        -y0 < -A/D*k <= 1e9-y0
//        (y0-1e9) /A*D <= k < y0/A*D
//                         k < -x0/B*D
                long kFromY = (long)Math.ceil((double) y0/ (double) a)-1; //D는 1이므로 생략
                long kFromX = (long)Math.ceil((double) -x0/ (double) b)-1;
//        k의 max를 구한 후 그 k의 값을 이용하여 y값을 구한다.
                long k = Math.min(kFromX, kFromY);
//        k가 커지면 y가 작아지기 때문에 그렇게 구한 y가 가장 작은 y의 값이다.
                long ans = y0 - a*k;
//        그렇게 구한 y의 값이 1e9보다 작건나 같으면 가능한 답이다.
                if (ans <= 1e9){
                    System.out.println(ans);
                }
//        그렇지 않으면 불가능한 답이다.
                else{
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }
    static int[] eGCD(int a, int b){
        int s0 = 1, t0 = 0, r0 = a;
        int s1 = 0, t1 = 1, r1 = b;

        int tmp;
        while (r1 != 0){
            int q = r0/r1;
            tmp = r0 - q*r1;    // 새로운 r
            r0 = r1;
            r1 = tmp;

            tmp = s0-q*s1;
            s0 = s1;
            s1 = tmp;

            tmp = t0-q*t1;
            t0 = t1;
            t1 = tmp;
        }
        int[] arr= {s0, t0, r0};
        return arr;
    }

}
