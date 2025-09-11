class Solution {
    public int findNumbers(int[] nums) {
       //Logic : Traverse the array one by one.
       //count of no. of digits of each element, if #digits%2 equals 0 then 
       // increase the global count of even numbers
       int cnt = 0;
       for(int num : nums){
        //logic to find numDigits 
        if((int)Math.log10(num)%2==1) cnt++;
       }

       return cnt;
    }
}