// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // Compute size of initial window with size <=k
        int goodCount = 0;
        for(int num : arr){
            if(num <= k)
                goodCount++;
        }
        
        //traverse the array find the minSwap
        int minSwap = goodCount; //Maximum no. of swap in worst case
        int badCount = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > k)
                badCount++;
                
            //if window size reached then calculate minSwap in that window
            if(i == goodCount-1)
                minSwap = Math.min(minSwap, badCount);
            else if(i >= goodCount){
                if(arr[i-goodCount] > k)
                    badCount--;
                minSwap = Math.min(minSwap, badCount);
            }
        }
        
        return minSwap;
    }
}
