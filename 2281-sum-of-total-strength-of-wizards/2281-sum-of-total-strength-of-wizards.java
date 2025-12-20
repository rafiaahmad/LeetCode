class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        long MOD = 1_000_000_007L;

        // Step 1.1 : Build prefix Sum
        long[] P = new long[n+1];
        for(int i = 0; i<n; i++)
            P[i+1] = P[i] + strength[i];

        // Step 1.2 : Build prefix Sum of prefix sum
        long[] PP = new long[n+2];
        for(int i = 0; i<=n; i++)
            PP[i+1] = (PP[i] + P[i]) % MOD;

        // Step 2 : Compute NSL and NSR
        int[] left = findNSL(strength);
        int[] right = findNSR(strength);

        long totalSum = 0;
        
        for(int i = 0; i<n; i++){

            // Step 3 : Interpret the boundries
            int l = i - left[i];
            int r = right[i] - i;

            // Step 4 : Contribution logic
            // int rightPrefixSum =  P[right+1] - P[left]
            long rightSum = 
            (PP[right[i] + 1] - PP[i + 1] + MOD) % MOD * l % MOD; 

            // int leftPrefixSum = P[i+1] - P[left]
            long leftSum = 
            (PP[i + 1] - PP[left[i] + 1] + MOD) % MOD * r % MOD;

            long currentSum = (rightSum - leftSum + MOD) % MOD;
            totalSum = (totalSum +   strength[i] * currentSum) % MOD;
        }

        return (int) totalSum;
    }

    // Helper function to calculate NSL
    private int[] findNSL(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return left;
    }

    // Helper function to calculate NSR
    private int[] findNSR(int[] arr){
        int n = arr.length;
        int[] right = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return right;
    }
}