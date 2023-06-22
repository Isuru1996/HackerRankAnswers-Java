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
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        if (m==0){
            return convertNumberToString(h)+" o' clock";
        }
        else if((m>=1)&&(m<=30)){
            if(m==15){
                return "quarter past "+convertNumberToString(h);
            }
            else if(m==30){
                return "half past "+convertNumberToString(h);
            }
            else if(m==1){
                return convertNumberToString(m)+" minute past "+convertNumberToString(h);
            }
            else{
                return convertNumberToString(m)+" minutes past "+convertNumberToString(h);
            }
        }
        else{
            if(m==45){
                return "quarter to "+convertNumberToString(h+1);
            }
            else if(Math.abs(m-60)==1){
                return convertNumberToString(Math.abs(m-60))+" minute to "+convertNumberToString(h+1);
            }
            else{
                return convertNumberToString(Math.abs(m-60))+" minutes to "+convertNumberToString(h+1);
            }
        }
    }
    
    private static final String[] numbers = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty"
    };

    public static String convertNumberToString(int number) {
        return numbers[number];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
