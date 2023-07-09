import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int output=0;
        boolean find=false;
        for(int i=s.size();i>=1;i--){
            List<List<Integer>> subsets = generateSubsets(s, i);

            for (List<Integer> subset : subsets) {
                if(nonDivisibleByK(subset,k)){
                    output=i;
                    find=true;
                    break;
                }
            }
            if(find){
                break;
            }
        }
        return output;
    }
    
    static List<List<Integer>> generateSubsets(List<Integer> nums, int subsetLength) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsetsHelper(nums, subsetLength, 0, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    static void generateSubsetsHelper(List<Integer> nums, int subsetLength, int start, List<Integer> currentSubset, List<List<Integer>> subsets) {
        if (currentSubset.size() == subsetLength) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            currentSubset.add(nums.get(i));
            generateSubsetsHelper(nums, subsetLength, i + 1, currentSubset, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
    
    static boolean nonDivisibleByK(List<Integer> s,int k){
        boolean output=true;
        for(int i=0;i<s.size()-1;i++){
            for(int j=i+1;j<s.size();j++){
                if((s.get(i)+s.get(j))%k==0){
                    output=false;
                    break;
                }
            }
            if (!output){
                break;
            }
        }
        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
