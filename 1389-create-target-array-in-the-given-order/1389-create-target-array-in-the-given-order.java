class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList <Integer> res = new ArrayList<>();
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            res.add(index[i], nums[i]);
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = res.get(i);
        }

        return nums;
   
    }
}