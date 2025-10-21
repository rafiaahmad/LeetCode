// User function Template for Java

class Solution {
    boolean findSwapValues(int[] a, int[] b) {
        //Approach 2 : Two Pointer Method time: O(n log n), space O(1)
        //Step 1 : find total Sum
        int sumA = 0, sumB = 0, diff = 0;
        
        for(int x : a) sumA += x;
        for(int x : b) sumB += x;
        
        // Step 2 : Calculate target
        diff = sumA - sumB;
        if(diff%2 != 0) return false;
        
        diff /= 2; 
        
        // Step 3 : Sort array in O(n log n) time
        Arrays.sort(a);
        Arrays.sort(b);
        
        //Step 4 : Pick two pointer for finding target
        int i = 0, j = 0;
        while(i<a.length && j<b.length){
            if(a[i] - b[j] == diff)
                return true;
            else if(a[i] - b[j] < diff)
                i++; //move in array A
            else
                j++; //move in array B
        }
        
        return false; // target not found
    }
}
