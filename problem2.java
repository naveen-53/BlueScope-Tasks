
import java.util.*;
public class problem2 {
public static void main(String[] args) {
String[] str= {"chair","racket","tunic","height","touch"};

Iscircle(str);

}
static void Iscircle(String[] str)
{
List<String[]> l=new ArrayList<>();

createPermutation(l,str,0);
for(String[] ll:l)
{
int flag =0;
for(int i=0; i<ll.length-1; i++)
{
if(ll[i].charAt(ll[i].length()-1)!= ll[i+1].charAt(0)) {
flag=1;
}

}
if(flag==0)
{
System.out.println(Arrays.toString(ll));
break;
}
}

return;
}
static void createPermutation(List<String[]> l,String[] str,int idx)
{
if(idx==str.length) {
l.add(str.clone());
return;
}
for(int i=idx; i<str.length; i++) {
swap(str,i,idx);
createPermutation(l,str,idx+1);
swap(str,i,idx);
}
}

static void swap(String[] s,int i,int j)
{
String temp=s[i];
s[i]=s[j];
s[j]=temp;
return;
}



}

