class Solution {
    public int characterReplacement(String s, int k) {
        // Time Complexity : O(n), Space complexity : O(1)
        int left = 0; int maxFreq = 0; int maxWindowLen = 0;
        // HashMap<Character, Integer> freq = new HashMap<>();
        int[] freq = new int[26];

        // Step 1 : Move Right
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);
            
            //Step 2 : Count frequency
            // freq.put(ch, freq.getOrDefault(ch, 0)+1);
            freq[ch - 'A']++;

            // Step 3 : Update Maximum Frequency
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // Step 3 : Check if window is valid
            // Window : Right - Left + 1
            while((right-left+1) - maxFreq > k){
                //Reduce the frequency
                char removeChar = s.charAt(left);
                // freq.put(removeChar, freq.get(removeChar)-1);
                freq[removeChar - 'A']--;
                // if(freq.get(removeChar) == 0) freq.remove(removeChar);

                left++; // shrink window from left
            }

            // Step 4 : Calcuate maximum Window length
            maxWindowLen = Math.max(maxWindowLen, right - left + 1);
        }

        return maxWindowLen;
    }
}