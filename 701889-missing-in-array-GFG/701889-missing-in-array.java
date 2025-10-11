class Solution {
    int missingNum(int arr[]) {
        int n = arr.length;
        
        //Step 1 : find XOR of 1..n+1
        int xor = 1;
        for(int i = 2; i<=n+1; i++){
            xor ^= i;
        }
        
        //Step 2 : xor element of arr with Xor of 1..n
        for(int i : arr){
            xor ^= i;
        }
        
        //Step 3 : final xor after loop gives the missing number
        return xor;
    }
}
