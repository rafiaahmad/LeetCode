class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        // Arrays.fill(visited, -1);

        // Step 1 : Build the freq. array
        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        Deque<Character> st = new ArrayDeque<>();

        // Step 2 : Process the string
        for(char ch : s.toCharArray()){
            freq[ch - 'a']--; // decrease the frequency

            if(visited[ch - 'a'])
                continue; // Skip as character alreasy visited

            // Pop when stack is not empty, the current character is smaller than existing
            // character on top of stack and it has non-zero frequency in the frequency array
            while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 0)
                visited[st.pop() - 'a'] = false;

            st.push(ch); // Push the character
            visited[ch - 'a'] = true; // mark visited
        }

        // Step 3 : Build result
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty())
            res.append(st.pop());

        return res.reverse().toString();
    }
}