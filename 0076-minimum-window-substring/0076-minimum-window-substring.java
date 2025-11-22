class Solution {
    public String minWindow(String s, String t) {
        // Step 1 : Find the length of both strings
        int m = s.length(), n = t.length();

        // Step 2 : Early exit
        if(m < n) return "";

        HashMap<Character, Integer> freqS = new HashMap<>();
        HashMap<Character, Integer> freqT = new HashMap<>();

        // Step 3 :Build frequency map for String t
        for(char ch : t.toCharArray())
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);

        // declare needful variable
        int left = 0;
        int have = 0, need = freqT.size();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // Step 4 : Slide the window over string s further        
        for(int right = 0; right<m; right++){

            // Step 4.1 : Add the new character
            char ch = s.charAt(right);
            freqS.put(ch, freqS.getOrDefault(ch, 0)+1);

            // Step 4.2 : Check if freqS matches freqT requirement
            if(freqT.containsKey(ch) && freqS.get(ch).intValue() == freqT.get(ch).intValue())
                have++;

            // Step 4.3 : Shrink window until window is valid
            while(have == need){
                // Track Best Window
                if(right-left+1 < minLen){
                    minLen = right - left + 1;
                    startIndex = left;
                }

                //Shrink from left
                char leftChar = s.charAt(left);
                freqS.put(leftChar, freqS.get(leftChar)-1);

                if(freqT.containsKey(leftChar) && freqS.get(leftChar) < freqT.get(leftChar) )
                    have--;

                left++; // Shrink window from left
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

    private boolean isValid(HashMap<Character, Integer> freqS, HashMap<Character, Integer> freqT){
        for(char ch : freqT.keySet()){
            if(freqS.get(ch) < freqT.get(ch))
                return false;
        }

        return true;
    }
}