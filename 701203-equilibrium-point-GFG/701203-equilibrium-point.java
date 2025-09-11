class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        // If array length <3 return
        if(n<3) return -1;
        
        //calculate initial PreSum and PostSum
        int PreSum = arr[0];
        int PostSum = 0;
        for(int i=2; i<n; i++) PostSum += arr[i];
        
        //Check for equilibrium index with range of index 2 to n-2
        for(int i=1; i<n-1; i++){
            if(PreSum == PostSum) return i; // return equilibrium index
            else{
                PreSum += arr[i];
                PostSum -= arr[i+1];
            }
        }
        return -1; //Equiblrium not found
    }
}
