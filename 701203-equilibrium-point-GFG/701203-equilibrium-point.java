class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        //Build prefix
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i<arr.length; i++)
            prefix[i] = prefix[i-1] + arr[i];
            
        //tarverse array from length 1..last ele. and check the equilibrium point
        for(int i = 1; i<arr.length; i++){
            //sum of ele. i+1 ... arr.length-1
            int postSum = prefix[arr.length - 1] - prefix[i];
            if(postSum == prefix[i-1])
                return i;
        }
        
        return -1;
    }
}
