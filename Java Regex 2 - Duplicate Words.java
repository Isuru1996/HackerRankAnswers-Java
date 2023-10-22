import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        // /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);
        int number=scan.nextInt();
        scan.nextLine();
        for(int i=0;i<number;i++){
            String s1=scan.nextLine();
            System.out.println(removeDuplicate(s1));
        }
    }
    
    public static String removeDuplicate(String s){
        StringBuffer s1=new StringBuffer();
        String arr[]=s.split(" ");
        for(int i=0;i<arr.length;i++){
            if(i==0){
                s1.append(arr[i]+" ");
            }
            else{
                Pattern pattern1 = Pattern.compile(" " + arr[i] + " ", Pattern.CASE_INSENSITIVE);
                Pattern pattern2 = Pattern.compile("^" + arr[i] + " ", Pattern.CASE_INSENSITIVE);
                Pattern pattern3 = Pattern.compile(" " + arr[i] + "$", Pattern.CASE_INSENSITIVE);

                Matcher matcher1 = pattern1.matcher(s1.toString());
                Matcher matcher2 = pattern2.matcher(s1.toString());
                Matcher matcher3 = pattern3.matcher(s1.toString());

                if (!(matcher1.find() || matcher2.find() || matcher3.find())) {
                    if(s1.toString().split(" ").length==1){
                        s1.append(arr[i]);
                    }
                    else {
                        s1.append(" ").append(arr[i]);
                    }
                }
            }
        }
        return s1.toString();
    }
}