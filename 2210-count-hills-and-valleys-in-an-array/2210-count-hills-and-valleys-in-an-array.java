class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // Remove consecutive duplicates
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                list.add(nums[i]);
            }
        }

        int count = 0;

        // Check hills and valleys
        for (int i = 1; i < list.size() - 1; i++) {
            int prev = list.get(i - 1);
            int curr = list.get(i);
            int next = list.get(i + 1);

            if (curr > prev && curr > next) {
                count++; // hill
            } else if (curr < prev && curr < next) {
                count++; // valley
            }
        }
        return count;
    }
}