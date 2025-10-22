class Solution {
    public String reverseWords(String s) {
        // Approach 1 : trim the leading and trailing space and
        // store the words into an string array
        // TC : O(n) , SC: O(n) -- string array
        String[] words = s.trim().split("\\s+"); // \\s+ = one or more spaces
        
        // Step 2: Reverse the array of words
        int left = 0; int right = words.length-1;
        while(left < right){
            String tmp = words[left];
            words[left] = words[right];
            words[right] = tmp;
            left++;
            right--;
        }

        // Step 3 : Join the words with single space
        return String.join(" ", words);
    }
}