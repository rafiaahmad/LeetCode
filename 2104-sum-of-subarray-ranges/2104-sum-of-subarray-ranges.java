class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sumMax = 0, // Sum of SubArray Maximums
             sumMin = 0; // Sum of SubArray Minimums

        // Step1 : Calculate NSL, NSR, NGL, NGR
        int[] leftS  = findNSL(nums);
        int[] rightS = findNSR(nums);
        int[] leftG  = findNGL(nums);
        int[] rightG = findNGR(nums);

        for (int i = 0; i < n; i++) {
            long lS = i - leftS[i];
            long rS = rightS[i] - i;

            long lG = i - leftG[i];
            long rG = rightG[i] - i;

            sumMin += nums[i] * lS * rS;
            sumMax += nums[i] * lG * rG;
        }

        return sumMax - sumMin; // Sum of Subarray Ranges
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

    // Helper function to calculate NGL
    private int[] findNGL(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return left;
    }

    // Helper function to calculate NGR
    private int[] findNGR(int[] arr){
        int n = arr.length;
        int[] right = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] < arr[i])
                st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return right;
    }
}