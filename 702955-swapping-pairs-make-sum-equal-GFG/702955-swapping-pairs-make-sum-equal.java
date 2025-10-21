// User function Template for Java

class Solution {
    boolean findSwapValues(int[] a, int[] b) {
        // Approach 1 : 
        int sumA = 0, sumB = 0, diff = 0;
        
        //Step 1 : Calculate total sum of both arrays
        for(int x : a)
            sumA += x;
            
        for(int x : b)
            sumB += x;
            
        //Step 2 : Calculate difference of both
        diff = sumA - sumB;
        
        if(diff%2 != 0) return false; // pair won't be integer
        diff /= 2;
        
        //Step 3 : Used a HashMap to store elements of array A
        HashSet<Integer> setA = new HashSet<>();
        
        for(int x : a)
            setA.add(x);
            
        // Step 4 : Iterate over array B and check if eligible for equal sum
        for(int x : b){
            if(setA.contains(x+diff))
                return true;
        }
        
        return false; //couldn't find any pair
    }
}
