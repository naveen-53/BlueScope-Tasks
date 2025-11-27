package DSA_Series;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_Series_5 {

    public static boolean kaprekarNumber(int num){
        if(num < 1000 || num > 9999){
            return false;
        }
        else {
            return true;
        }

    }

    public static int countStep(int num){

        int count=0;
        while (num!=6174){
            String str = String.format("%04d",num);
            char[] arr =str.toCharArray();
            Arrays.sort(arr);
            String smallString=String.valueOf(arr);
            for(int i=0;i<arr.length/2;i++){
                char temp = arr[i];
                arr[i]=arr[arr.length-1-i];
                arr[arr.length-1-i]=temp;
            }
            String largeString=String.valueOf(arr);

            int smallNum=Integer.parseInt(smallString);
            int largeNum=Integer.parseInt(largeString);

            num=largeNum-smallNum;
            count++;
        }
        return count;
    }

    static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.println("Enter the number");
        int number = scanner.nextInt();

        if(!kaprekarNumber(number)){
            System.out.println("Enter the valid number");
        }
        else {
            System.out.println("Total steps "+countStep(number));
        }


    }
}
