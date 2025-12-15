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
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        int n = operations.size();
        Deque<Integer> mainStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        
        for(String op : operations){
            // Split the operation string
            String[] parts = op.split(" ");
            
            int key = Integer.parseInt(parts[0]);
            
            if(key == 1){
                // Push into main Stack
                int val = Integer.parseInt(parts[1]);
                mainStack.push(val);
                if(maxStack.isEmpty() || val >= maxStack.peek())
                    maxStack.push(val);
            } else if (key == 2){
                if(!mainStack.isEmpty()){
                int popped = mainStack.pop();
                
                if(popped == maxStack.peek())
                   maxStack.pop();
                }
            } else{
                res.add(maxStack.peek());
            }             
        }
        
        return res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
