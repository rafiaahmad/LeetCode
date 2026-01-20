class Solution {
    public void nearlySorted(int[] arr, int k) {
        
        // Step 1: Build Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int idx = 0;
        
        // Process array element inside heap maintaining size k
        for(int i = 0; i<arr.length; i++){
            minHeap.offer(arr[i]); // Push the element

            if(minHeap.size() > k) 
                arr[idx++] = minHeap.poll(); // Remove unnecessary while sorting
        }
        
        // add reamining elements to sorted array
        while (!minHeap.isEmpty())
        arr[idx++] = minHeap.poll();
    }
}
