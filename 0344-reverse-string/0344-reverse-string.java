class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }

    private void reverse(char[] s, int left, int right){
        if(left >= right) return;

        //swap first and last
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;

        //call recursive function
        reverse(s, left+1, right-1);
    }
}