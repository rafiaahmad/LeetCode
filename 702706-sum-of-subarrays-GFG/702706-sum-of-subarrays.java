class Solution {
    public int subarraySum(int[] arr) {
        int sum = 0; 
        int n = arr.length;
        for(int i = 0; i<n; i++){
            sum += (n-i)*(i+1)*arr[i];
        }
        
        return sum;
    }
}
