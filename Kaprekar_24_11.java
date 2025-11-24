import java.lang.reflect.Array;
import java.util.Arrays;

public class Kaprekar_24_11 {
    static int sortAsc(int n){
        char[] arr=String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return Integer.parseInt(new String(arr));
    }
    static int sortDesc(int n){
        char[] arr=String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder(new String(arr));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
    static void solve(int n){

        int cnt=0;
        while(n!=6174){
            if(!checkKaprekar(n)) {
                System.out.println("Invalid number");
                return;
            }
            cnt++;
            int asc=sortAsc(n);
            int desc=sortDesc(n);
            System.out.println("Asc: "+asc+" Desc: "+desc);
            n=desc-asc;
        }
        System.out.println("Number: "+cnt);
    }
    static boolean checkKaprekar(int n){
        String temp=String.valueOf(n);
        boolean checkcount=temp.chars().distinct().count()>=2;
        if(temp.length()==4 && checkcount)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int n=1114;
        solve(n);
    }
}
