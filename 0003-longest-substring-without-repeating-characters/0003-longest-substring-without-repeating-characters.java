class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Step 1: return string as it is length <=1
        if(s.length() < 1) return s.length();

        //Step 2 : Declare 2 pointers
        int left = 0, maxLen = 0; //Initial window size 

        HashMap<Character, Integer> freq = new HashMap<>();
        // freq.put(s.charAt(left), freq.getOrDefault(s.charAt(left), 0)+1);

        for(int right = 0; right < s.length(); right++){

            char curr = s.charAt(right);
            
            // Step 3 : Check if Valid Substring
            if(!freq.containsKey(curr)){
                //right-left+1 : Unique Window size
                maxLen = Math.max(maxLen, (right-left)+1);
                freq.put(curr, freq.getOrDefault(curr, 0) + 1);
                continue;
            }
            

            // Step 4 : Remove duplicates
            while(freq.containsKey(curr)){
                char removeChar = s.charAt(left);
                left++; //window shrink
                freq.put(removeChar, freq.get(removeChar) - 1);
                if(freq.get(removeChar) == 0)
                    freq.remove(removeChar); //reduce the frequency also
            }

            //Step 5 : Add the frequency
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
        }

        return maxLen;
    }
}