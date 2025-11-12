class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sort to group duplicates

        List<List<Integer>> res = new ArrayList<>();

        //Array to keep track of used elements of the array
        boolean[] used = new boolean[nums.length];

        //Recursive function
        generate(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void generate(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> res){
        //Base case : when current size == array size
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
            
        //Looping through the choices
        for(int i = 0; i<nums.length; i++){
            //Skip already used elements
            if(used[i]) continue;

            // Avoid duplicate: Only pick first unused element
            if(i>0 && nums[i] == nums[i-1] && (!used[i-1])) continue;

            //Choose: Mark as used and add into current list
            used[i] = true;
            current.add(nums[i]);

            //recursive function to build next possible permutation
            generate(nums, used, current, res);

            //Backtracking : Un-Choose
            used[i] = false;
            current.remove(current.size() -1);
        }
    }
}