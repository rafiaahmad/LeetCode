class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generate(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void generate(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> res){
        //Base case
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
            

        for(int i = 0; i<nums.length; i++){
            if(used[i]) continue;

            if(i>0 && nums[i] == nums[i-1] && (!used[i-1])) continue;

            used[i] = true;
            current.add(nums[i]);
            generate(nums, used, current, res);

            used[i] = false;
            current.remove(current.size() -1);
        }
    }
}