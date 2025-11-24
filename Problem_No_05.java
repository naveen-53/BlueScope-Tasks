package DSA;
import java.util.Arrays;
import java.util.Scanner;
public class Program_05 {
    public static boolean check(int number) {
        if (number < 1000 || number > 9999) {
            System.out.println("Enter the valid number");
            return false;
        } else {
            return true;
        }
    }
    public static int kaprekar(int number) {
        int steps = 0;
        while (number != 6174) {
            String s = String.format("%04d", number);
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String smallStr = ""+arr[0]+arr[1]+arr[2]+arr[3];
            String bigStr = ""+arr[3]+arr[2]+arr[1]+arr[0];
            int small = Integer.parseInt(smallStr);
            int big = Integer.parseInt(bigStr);
            number = big - small;
            steps++;
            System.out.println(bigStr + " - " + smallStr + " = " +String.format("%04d", number));
        }
        return steps;
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = obj.nextInt();
        if (!check(number)) {
            return;
        }
        int result=kaprekar(number);
        System.out.println("Steps : " + result);
    }
}
