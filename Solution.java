package test.org;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a 4 digit number ");
		String s= sc.next();//1234
		if(s.length()==4) {
			int count=0;
			int kaplar_num=6174;
			int num=Integer.parseInt(s);
			while(num!=kaplar_num) {
				int big=descending(String.valueOf(num));
				int small=ascending(String.valueOf(num));
				num=big-small;
				System.out.println(big+" "+" - " +small+" "+" = "+num);
 				count++;
				}
			System.out.println(count);
}else {
		System.out.println("please,Enter a 4 digit number ");
		}}

	private static int descending(String s) {
		int dec=0;
		int arr[]= new int[s.length()];
 		for(int i=0;i<s.length();i++) {
			arr[i]=s.charAt(i)-'0';
			 }
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp; 
					}}}
		for(int i =0;i<arr.length;i++) {
			dec=dec*10+arr[i];
		}
  		return dec;
	}

	private static int ascending(String s) {
		int asc=0;
		int arr[]= new int[s.length()];
 		for(int i=0;i<s.length();i++) {
			arr[i]=s.charAt(i)-'0';
			 }
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp; 
					}}}
		for(int i =0;i<arr.length;i++) {
			asc=asc*10+arr[i];
		}
  		return asc;
	}
	}