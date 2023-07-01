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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        int maxPerimeter=0;       
        Collections.sort(sticks);     
        ArrayList<Integer> tri=new ArrayList<Integer>();
        if(sticks.size()<3){
            tri.add(-1);
        }
        else{
                    for(int i=0;i<sticks.size()-2;i++)
                    {
						for(int j=i+1;j<sticks.size()-1;j++){
							for(int k=j+1;k<sticks.size();k++){
								if(sticks.get(i)+sticks.get(j)>sticks.get(k)){
									if(maxPerimeter<(long)sticks.get(i)+sticks.get(j)+sticks.get(k)){
										maxPerimeter=sticks.get(i)+sticks.get(j)+sticks.get(k);
										tri.clear();
										tri.add(sticks.get(i));
										tri.add(sticks.get(j));
										tri.add(sticks.get(k));
									}
									else if(maxPerimeter==sticks.get(i)+sticks.get(j)+sticks.get(k)){
										if(findMax(tri.get(0),tri.get(1),tri.get(2))<findMax(sticks.get(i),sticks.get(j),sticks.get(k))){
											tri.clear();
											tri.add(sticks.get(i));
											tri.add(sticks.get(j));
											tri.add(sticks.get(k));
										}
										else if(findMax(tri.get(0),tri.get(1),tri.get(2))==findMax(sticks.get(i),sticks.get(j),sticks.get(k))){
											if(findMax(tri.get(0),tri.get(1),tri.get(2))>findMin(sticks.get(i),sticks.get(j),sticks.get(k))){   
												tri.clear();
												tri.add(sticks.get(i));
												tri.add(sticks.get(j));
												tri.add(sticks.get(k));
											}
										}
									}
								}
							}
						}
					}
        }

        
        if(maxPerimeter==0||tri.size()==0){
            tri.add(-1);
        }
        
            return tri;

    }
    
    static int findMax(int a,int b,int c){
        if(a>b){
            if(a>c){
                return a;
            }
            else{
                return c;
            }
        }
        else{
            if(b>c){
                return b;
            }   
            else{
                return c;
            }
        }
    }
    
    static int findMin(int a,int b,int c){
        if(a<b){
            if(a<c){
                return a;
            }
            else{
                return c;
            }
        }
        else{
            if(b<c){
                return b;
            }   
            else{
                return c;
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
