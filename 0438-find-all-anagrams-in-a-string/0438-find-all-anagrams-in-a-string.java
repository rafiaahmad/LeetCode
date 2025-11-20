class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] countP = new int[26];
        int[] countS = new int[26];

        List<Integer> res = new ArrayList<>();

        // Step 1 : Early exit
        if(s.length() < p.length()) return res;

        // Step 2 : Count frequency of s1 and first window of s2
        for (int i = 0; i < p.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countP[p.charAt(i) - 'a']++;
        }
        int startIndex = 0;

        // Step 2.1 : Check initial window
        if (matches(countS, countP))
            res.add(startIndex);

        // Step 3 : Slide the window over string S
        for (int i = p.length(); i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++; // add new char
            countS[s.charAt(i - p.length()) - 'a']--; // remove old char

            // Step 3.1 : Check the current window
            if (matches(countS, countP)) res.add(i-p.length()+1);
        }

        return res;
    }

    // function to check anagram
    private boolean matches(int[] countS, int[] countP){
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countP[i]) return false;
        }
        return true;
    }
}