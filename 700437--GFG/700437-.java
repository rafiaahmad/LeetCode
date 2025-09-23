class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> result  = new ArrayList<>();
        
        for(int i = 0; i<arr.length; i++){
            //Map index to value
            int index = Math.abs(arr[i]) - 1;
            
            if(arr[index] < 0)
                //mark as duplicate
                result.add(Math.abs(arr[i]));
            else
                //Mark Visited
                arr[index] = -arr[index];
        }
        
        return result;
    }
}