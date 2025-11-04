class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //Step 1 : Sort the array using O(nlogn) time
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void generate(int[] nums, int index, List<Integer> current,     List<List<Integer>> res){
        //Base Case : Add current subset (it's always valid)
        res.add(new ArrayList<>(current));

        // Loop through choices
        for(int i = index; i<nums.length; i++){
            //Avoid duplicates
            if(i>index && nums[i] == nums[i-1]) continue;

            //Otherwise Include this element
            current.add(nums[i]);
            generate(nums, i+1, current, res);

            //Backtracking
            current.remove(current.size()-1);
        }
    }
}