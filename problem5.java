import java.util.*;
public class problem5
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int n = sc.nextInt();
		if(n<9999&&n>=1000){
		int count=kaprekar(n,0);

         if(count==0){
             System.out.println("This number is not a Kaprekar");
         }
         else{
		System.out.println(count);}
		}
		else{
		    System.out.println("give 4 digit value");
		}
	}
	public static int kaprekar(int n,int count)
	{
		if(n==6174)
		{
			return 0;
		}
		List<Integer> Ascending=new ArrayList<>();
		while(n>0) {
			Ascending.add(n%10);
			n=n/10;
		}
		int small=0;
		int big=0;
		Collections.sort(Ascending);
		for(int i=0; i<Ascending.size(); i++)
		{
			small=small*10+Ascending.get(i);
		
		}
		for(int i=Ascending.size()-1; i>=0; i--)
		{
			big=big*10+Ascending.get(i);
		}
		count++;
	
		int s=big-small;
		if(s==0)
		{
		    return 0;
		}
		System.out.println(s);
		if(s==6174)
		{
			return count;
		}


		return  kaprekar(s,count);



	}
}