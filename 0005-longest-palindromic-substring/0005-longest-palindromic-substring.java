class Solution {
    public String longestPalindrome(String s) {
        // Approach 1 : Brute-force 
        // T.C: O(n^3), S.C: O(1)
        int maxLength = 0;
        int n = s.length();
        String result = "";

        for(int i = 0; i<n; i++){ // O(n)
            for(int j = i; j<n; j++){ // O(n)
                if(isPalindrome(s, i, j)){ // O(n)
                    int length = j-i+1;
                    if(length > maxLength){
                        maxLength = length;
                        result = s.substring(i, j+1);
                    }
                }
            }
        }

        return result;
    }

    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}