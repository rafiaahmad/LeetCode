class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        
        int n = nums.length;
        int[] result = new int[n];        

        int size = 0; // how many elements are "validly filled"

        for(int i=0; i<n; i++){
            int pos = index[i];

            // shift elements to the right from pos..size-1
            for(int j=size; j>pos; j--){
                result[j] = result[j-1];
            }

            result[pos] = nums[i];
            size++;
        }
        return result;
    }
}