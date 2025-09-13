class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        
        // PreSum: sum of elements before index i
        int PreSum = arr[0];
        
        // PostSum: sum of elements after index i (starting from index 2)
        int PostSum = 0;
        for(int i=2; i<n; i++) PostSum += arr[i];
        
        // Check equilibrium from index 1 to n-2
        for(int i=1; i<n-1; i++){
            if(PreSum == PostSum) 
                return i; // equilibrium index (0-based)
            else{
                PreSum += arr[i];       // expand left sum
                PostSum -= arr[i+1];    // shrink right sum
            }
        }
        return -1; //No equiblrium found
    }
}
