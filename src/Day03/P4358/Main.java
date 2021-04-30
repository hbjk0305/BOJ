package Day03.P4358;
import java.io.*;
import java.util.*;
public class Main {
    static Map<String, Integer> species;
    public static void main(String[] args) throws Exception{
        species = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        double total = 0;
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            if (input.length() == 0) break;
//            System.out.println(input+"!");
            if (species.containsKey(input)){
                species.put(input, species.get(input)+1);
            }
            else{
                species.put(input, 1);
            }
            total += 1;
        }
        for (String name: species.keySet()){
            String ratio = String.format("%.4f", species.get(name)*100.0/total);
            System.out.println(name+" "+ratio);
        }
    }
}
