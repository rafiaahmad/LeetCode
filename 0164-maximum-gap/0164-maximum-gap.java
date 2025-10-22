class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;

        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        if (min == max) return 0; // all numbers same

        // 1️⃣ Calculate bucket size and count
        int bucketSize = (int) Math.ceil((double)(max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // 2️⃣ Place numbers into buckets
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }

        // 3️⃣ Compute maximum gap
        int maxGap = 0;
        int prevMax = min;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue; // empty bucket
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
}