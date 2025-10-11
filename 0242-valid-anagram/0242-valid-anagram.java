class Solution {
    public boolean isAnagram(String s, String t) {
        //Step 1 : Return if string length unequal
        if(s.length() != t.length()) return false;

        //Step 2 : Frequncy based counting
        int[] freq = new int[26]; // for 'a' to 'z'

        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++; // add for s
            freq[t.charAt(i) - 'a']--; //subtract for t
        }

        for(int val : freq){
            if(val != 0)
                return false; //unbalanced frequency -> not anagram
        }

        return true;
    }
}