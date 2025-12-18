package com.example.sample;

import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {

    public static int kaprekarSteps(int n) {
        final int KAPREKAR_CONSTANT = 6174;
        int steps = 0;

        while (n != KAPREKAR_CONSTANT) {
        	
            String num = String.format("%04d", n);

            char[] digits = num.toCharArray();

            Arrays.sort(digits);
            int asc = Integer.parseInt(new String(digits));

            String descStr = new StringBuilder(new String(digits)).reverse().toString();
            int desc = Integer.parseInt(descStr);

            n = desc - asc;
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 digit Number which has two distinct digits : ");
        int number = sc.nextInt();
        System.out.println(kaprekarSteps(number));
    }
}
