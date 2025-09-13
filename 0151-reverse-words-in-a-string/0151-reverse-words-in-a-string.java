class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] words = s.trim().split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) stack.push(word);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) sb.append(" ");
        }
        return sb.toString();
    }
}