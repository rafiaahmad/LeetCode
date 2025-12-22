class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {

        int n = s.length();
        int remainingLetter = 0;

        // Count total occurrences of `letter`
        for (char c : s.toCharArray()) {
            if (c == letter) remainingLetter++;
        }

        int usedLetter = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            // Try to pop for lexicographical order
            while (!stack.isEmpty()
                    && stack.peek() > curr
                    && stack.size() - 1 + (n - i) >= k
                    && (stack.peek() != letter || remainingLetter > repetition - usedLetter)) {

                char removed = stack.pop();
                if (removed == letter) usedLetter--;
            }

            // Try to push current character
            if (stack.size() < k) {
                if (curr == letter) {
                    stack.push(curr);
                    usedLetter++;
                } else {
                    // Ensure space for required letters
                    if (k - stack.size() > repetition - usedLetter) {
                        stack.push(curr);
                    }
                }
            }

            if (curr == letter) remainingLetter--;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) result.append(c);

        return result.reverse().toString();
    }
}