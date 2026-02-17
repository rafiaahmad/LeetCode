class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Step 1: Early return case
        if(s.length() < 1) return s.length();

        //Step 2 : Left pointer, maxLen initialization
        int left = 0, maxLen = 0; //Initial window size 

        //Step 3 : HashMap to store frequency
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int right = 0; right < s.length(); right++){

            char curr = s.charAt(right);
            
            // Step 4 : Checking for duplicate
            if(!freq.containsKey(curr)){
                //right-left+1 : Unique Window size
                maxLen = Math.max(maxLen, (right-left)+1);
                freq.put(curr, freq.getOrDefault(curr, 0) + 1);
                continue;
            }            

            // Step 5 : Shrinking the window
            while(freq.containsKey(curr)){
                char removeChar = s.charAt(left);
                left++; 
                freq.put(removeChar, freq.get(removeChar) - 1);
                if(freq.get(removeChar) == 0)
                    freq.remove(removeChar); //reduce the frequency also
            }

            //Step 5 : Adding the current character after shrink
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
        }

        return maxLen;
    }
}