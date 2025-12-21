class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        
        // 1. Frequency of each character
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // 2. To check if char is already in the result stack
        boolean[] inStack = new boolean[26];
        
        // 3. Use StringBuilder as a stack
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            // Decrease remaining count
            freq[idx]--;
            
            // If already included, skip
            if (inStack[idx]) {
                continue;
            }
            
            // While stack is not empty and:
            // - last char is greater than current char (for lexicographically smaller result)
            // - and last char will appear again later (freq[...] > 0)
            while (stack.length() > 0) {
                char last = stack.charAt(stack.length() - 1);
                int lastIdx = last - 'a';
                
                if (last > c && freq[lastIdx] > 0) {
                    // We can remove last and add it later
                    stack.deleteCharAt(stack.length() - 1);
                    inStack[lastIdx] = false;
                } else {
                    break;
                }
            }
            
            // Add current character to stack/result
            stack.append(c);
            inStack[idx] = true;
        }
        
        return stack.toString();
    }
}