class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        // Step 1 : Traverse the array from index 0 to n-1
        for(int i = 0; i < n; i++){
            // 1. Add index i : Maintain Decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast(); // remove smaller element

            // 2. Add current index
            dq.offerLast(i);

            // 3. Remove Out-Of-Window index
            if(!dq.isEmpty() && dq.peekFirst() < i-k+1)
                dq.pollFirst();

            // 4. Store Current Window Maximum
            if (i >= k-1)
                res.add(nums[dq.peekFirst()]);
        }

        int[] ans = new int[res.size()];
        for(int i = 0; i<res.size(); i++)
            ans[i] = res.get(i);

        return ans;
    }
}