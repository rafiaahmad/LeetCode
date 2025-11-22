class Solution {
    public String minWindow(String s, String t) {
        // Step 0 : Early Return
        if(s.length() < t.length()) return "";

        int[] freqT = new int[256];
        int[] freqS = new int[256];

        // Step 1 : Build frequency array for string T
        int need = 0;
        for(char ch : t.toCharArray()){
            if(freqT[ch] == 0) need++;
            freqT[ch]++;
        }

        // Declare necessary variable for finding minimum window substring
        int have = 0, minIndex = 0, minLen = Integer.MAX_VALUE;
        int left = 0;

        // Step 2 : SLIDING WINDOW : Traverse String S using Right pointer
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freqS[ch]++;    // Add the frequncy for new character

            // Check if freqT need the character or not
            if(freqT[ch] != 0 && freqS[ch] == freqT[ch])
                have++;     

             // When window is valid → shrink
            while(have == need){

                // Track best window
                if(right-left+1 < minLen){
                    minLen = right - left + 1;
                    minIndex = left;
                }

                // Shrink from left
                char leftChar = s.charAt(left);
                freqS[leftChar]--;
                
                if(freqT[leftChar] != 0 && freqS[leftChar] < freqT[leftChar])
                    have--;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE? "" : s.substring(minIndex, minIndex + minLen);
    }
}