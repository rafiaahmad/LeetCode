class Solution {
    public int smallestDistancePair(int[] nums, int k) {
//         //Brute Force Approach
//         List <Integer> distances = new ArrayList<>();

//         //generate all possible pairs and calculate distances
//         for(int i=0; i<nums.length; i++){
//             for(int j = i+1; j<nums.length; j++){
//                 distances.add(Math.abs(nums[i] - nums[j]));
//             }
//         }
//         //sort the list of distances
//         Collections.sort(distances);

//         //return the k-1th index
//         return (distances.get(k-1));
//     }
// }
        Arrays.sort(nums); // sort the array

        int low = 0, high = nums[nums.length-1] - nums[0];

        while(low<high){
            int mid = low + (high-low)/2;

            //count how many pairs <=mid
            int count = 0, j=0;
            for(int i = 0; i<nums.length; i++){
                while(j<nums.length && nums[j]-nums[i] <=mid){
                    j++;
                }
                count += (j-i-1);
            }

            if(count >=k){ // mid is big enough
                high = mid;
            } else{
                low = mid+1; // need bigger distance
            }
        }
        return low;
    }
}
