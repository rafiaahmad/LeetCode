class Solution {
    private int[] counts; // stores the result
    private int[] indexes; // to track original indexes

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        indexes = new int[n];

        // initially, indexes = [0,1,2,...,n-1]
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        // apply merge sort on indexes based on nums values
        mergeSort(nums, 0, n - 1);

        // convert counts array to list
        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int rightCount = 0; // how many from right half are placed before left[i]
        
        int[] newIndexes = new int[right - left + 1];
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                // right element is smaller than left element
                rightCount++;
                newIndexes[k++] = indexes[j++];
            } else {
                // nums[indexes[i]] <= nums[indexes[j]]
                counts[indexes[i]] += rightCount;
                newIndexes[k++] = indexes[i++];
            }
        }

        // left over left half
        while (i <= mid) {
            counts[indexes[i]] += rightCount;
            newIndexes[k++] = indexes[i++];
        }

        // left over right half
        while (j <= right) {
            newIndexes[k++] = indexes[j++];
        }

        // copy back to indexes[]
        for (int p = 0; p < newIndexes.length; p++) {
            indexes[left + p] = newIndexes[p];
        }
    }
}
