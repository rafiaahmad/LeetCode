class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        //calculate total Sum
        int totalSum = 0;
        for(int x : arr)
            totalSum += x;
            
        //Calculate leftSum, rightSum and compare
        int leftSum = arr[0];
        for(int i = 1; i<arr.length; i++){
            int rightSum = totalSum - leftSum -arr[i];
            if(leftSum == rightSum)
                return i;
            else
                leftSum += arr[i];
        }
        
        return -1;
    }
}
