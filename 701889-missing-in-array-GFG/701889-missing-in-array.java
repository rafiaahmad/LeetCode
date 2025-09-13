class Solution {
    int missingNum(int arr[]) {
        // //Approach1: NumberSum - ArraySm give the result
        // int n = arr.length+1;
        // int SumN = (n* (n+1))/2;
        // int SumArr = 0;
        
        // for(int i = 0; i<arr.length; i++) SumArr += arr[i];
        
        // return (SumN - SumArr);
        
        // Approach2: XOR bit Manipulation
        int n = arr.length+1; //One number is missing
        int xor = 0;
        
        //XOR all elements from 1..n
        for(int i=1; i<=n; i++) xor ^= i;
        
        //XOR all elements in the array
        for(int num : arr) xor ^= num;
        
        return xor; // The result is the missing number
    }
}