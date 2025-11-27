package DSA_Series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_Series_2 {

    static void permute(String[] arr, int idx, List<String[]> res){
        if(idx==arr.length){
            res.add(arr.clone());
            return;
        }
        for(int i=idx;i<arr.length;i++){
            swap(arr,i,idx);
            permute(arr,idx+1,res);
            swap(arr,i,idx);
        }
    }
    static void swap(String[] arr,int i,int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static boolean isCircle(String arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i].charAt(arr[i].length()-1)!=arr[i+1].charAt(0)){
                return false;
            }
        }
        return arr[0].charAt(0)==arr[arr.length-1].charAt(arr[arr.length-1].length()-1);
    }
    public static boolean circleForm(String[] arr){
        int n=arr.length;
        List<String[]> res=new ArrayList<>();

        permute(arr,0,res);

        for(String[] s:res){
            if(isCircle(s)){
                System.out.println(Arrays.toString(s));
                return true;
            }
        }
        return false;
    }

    static void main(String[] args) {
        String[] arr={"chair","height","rocket","touch","tunic"};
        if(circleForm(arr))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
