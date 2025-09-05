class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i<arr.length; i++){
            int index = Math.abs(arr[i]) - 1; // ✅ adjust for 1..n range
        
            if(arr[index] < 0){
                result.add(Math.abs(arr[i])); // ✅  find duplicate
            } else{
                arr[index] = - arr[index]; //  ✅  mark visited
            }
        }
        
        return result;
    }
}