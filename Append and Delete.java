import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        if(s.equals(t)){
            System.out.println("Equal");
            if((s.length()==0)||(k>=s.length()*2)||(k%2==0)){
                return "Yes";
            }
            else{
                return "No";
            }
        }
        StringBuffer sb1=new StringBuffer(s);
        StringBuffer sb2=new StringBuffer(t);
        int number_of_steps=0;
        if(sb1.length()==0){
            number_of_steps=sb2.length();
            if(number_of_steps<k){
                number_of_steps=k;
            }
        }
        else if(sb2.length()==0){
           number_of_steps=sb1.length();
            if(number_of_steps<k){
                number_of_steps=k;
            } 
        }
        else if(sb1.charAt(0)!=sb2.charAt(0)){
            number_of_steps=sb1.length()+sb2.length();
            if(number_of_steps<k){
                number_of_steps=k;
            } 
        }
        else{
            int for_loop_length=(sb1.length()<sb2.length())? sb1.length(): sb2.length();
            int j=0;
            for(j=0;j<for_loop_length;j++){
                if(sb1.charAt(j)!=sb2.charAt(j)){
                    break;
                }
            }
            if(j==for_loop_length){
                number_of_steps=Math.abs(sb1.length()-sb2.length());
                System.out.println(number_of_steps);
                if(number_of_steps<k){
                    if((k-number_of_steps)%2==0){
                        number_of_steps=k;
                    }
                    else if((k-number_of_steps)>sb2.length()){
                        number_of_steps=k;
                    }
                }
            }
            else{
                number_of_steps=(sb1.length()-j)+(sb2.length()-j);
            }
        }
        if(number_of_steps==k){
            return "Yes";
        }
        else{
            return "No";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
