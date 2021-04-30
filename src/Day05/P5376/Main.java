package Day05.P5376;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0; i< n; i++){
            String line = br.readLine().substring(2);
            int length = 0, inParan = 0;
            boolean isParan = false;
            StringBuilder denom = new StringBuilder();
            StringBuilder delim = new StringBuilder();
            StringBuilder minus = new StringBuilder("0");
            for (int c = 0; c < line.length(); c++){
                char tmp = line.charAt(c);
//                System.out.println(tmp);
                if (tmp == '('){
                    isParan = true;
                }
                else if (tmp != ')'){   //숫자라는 뜻
                    length++;
                    delim.append(tmp);
                    if (isParan){
                        inParan++;
                        denom.append("9");
                    }
                    else{
                        minus.append(tmp);
                        denom.append("0");
                    }
                }

            }
            if (!isParan){
                denom.append("1");
            }
//            System.out.println(delim.toString()+" "+minus.toString());
            long del = Long.parseLong(delim.toString());
            if (isParan) {
                del -= Long.parseLong(minus.toString());
            }
            long den = Long.parseLong(denom.reverse().toString());
            long gcd = GCD(del, den);
            System.out.println(del/gcd+"/"+den/gcd);

        }
    }
    static long GCD(long a, long b){
        if (b == 0) return a;
        else return GCD(b, a%b);
    }
}
