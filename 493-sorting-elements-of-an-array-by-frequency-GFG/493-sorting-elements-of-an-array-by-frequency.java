import java.util.*; 
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of Test Cases
        
        while(T-- > 0){
            int N = sc.nextInt(); // size of array
            int[] arr = new int[N];
            
            //Step0: Input original array
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }
            
            //Step 1: Store frequency
            HashMap<Integer, Integer> freq = new HashMap<>();
            int maxFreq = 0;
            for(int x : arr){
                freq.put(x, freq.getOrDefault(x, 0) + 1);
                maxFreq = Math.max(maxFreq, freq.get(x));
            }
            
            //Step 2: Create Buckets
            List<List<Integer>> buckets = new ArrayList<>();
            for(int i = 0; i<=maxFreq; i++){
                buckets.add(new ArrayList<>());
            }
            
                
            //Step 3: Put the numbers in corresponding buckets
            for(int key : freq.keySet()){
                int f = freq.get(key);
                buckets.get(f).add(key);
            }
            
            //Step 4: Build result array
            int[] result = new int[arr.length];
            int index = 0;
            
            //Iterate from high frequency to low frequency
            for(int i = maxFreq; i>=1; i--){
               for(int num : buckets.get(i)){
                   for(int j = 0; j<i; j++)
                        result[index++] = num;
               }
            }
            
            //Print the array
            for(int i : result){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}