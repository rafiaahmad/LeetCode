class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right && left < s.length && right >= 0){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }
}