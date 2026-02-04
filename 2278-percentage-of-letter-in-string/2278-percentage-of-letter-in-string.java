class Solution {
    public int percentageLetter(String s, char letter) {
        int[] freq = new int[26];

        // Step 1: count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // calculate percentage
        // int res = (freq[letter - 'a'] / s.length()) * 100;

        return (freq[letter - 'a'] * 100) / s.length();
    }
}