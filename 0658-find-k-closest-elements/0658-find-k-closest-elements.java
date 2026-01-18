class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        // Binary search for the best window start
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Compare distances at window boundaries
            if (x - arr[mid] <= arr[mid + k] - x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // Collect k elements from the final window
        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}