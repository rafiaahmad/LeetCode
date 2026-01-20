class Solution {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        // Step 1 : Find Kth smallest
        long numK1 = findKthSmallest(A, K1); // 5
        long numK2 = findKthSmallest(A, K2); // 15

        // Step 2 : Traverse the array and calculate sum
        long sum = 0;
        for(long x : A){
            if(x > numK1 && x < numK2)
                sum+= x;
        }
        
        return sum;
    }
    
    private static long findKthSmallest(long[] arr, long k){
        // Build heap
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(long num : arr){
            maxHeap.offer(num);

            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
