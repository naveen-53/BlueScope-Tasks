import java.util.*;
public class KaprekarSoln {
    public static int kaprekarSteps(int n) {
        int steps = 0;
        while (n != 6174) {
            String s = String.format("%04d", n); 
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            int small = Integer.parseInt(new String(arr));
            String descStr = new StringBuilder(new String(arr)).reverse().toString();
            int large = Integer.parseInt(descStr);
            n = large - small; 
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(kaprekarSteps(1234)); 
    }
}