import java.util.*; 
public class Main {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of test cases
        
        while (T-- > 0) {
            int N = sc.nextInt(); // size of array
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            // Step 1: Count frequency
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int x : arr) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
            
            // Step 2: Put array elements into list for custom sorting
            List<Integer> list = new ArrayList<>();
            for (int x : arr) list.add(x);
            
            // Step 3: Sort by frequency, then by value
            Collections.sort(list, (a, b) -> {
                int fa = freq.get(a);
                int fb = freq.get(b);
                
                if (fa != fb) {
                    return fb - fa; // higher frequency first
                } else {
                    return a - b;   // smaller element first
                }
            });
            
            // Step 4: Print result
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}