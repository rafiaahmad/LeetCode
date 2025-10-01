class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        List <Integer> distances = new ArrayList<>();

        //generate all possible pairs and calculate distances
        for(int i=0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                distances.add(Math.abs(nums[i] - nums[j]));
            }
        }

        //sort the list of distances
        Collections.sort(distances);

        //return the k-1th index
        return (distances.get(k-1));
    }
}