class Solution {
    public boolean isIsomorphic(String s, String t) {
        //Approach1: Using Arrays
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256]; // maps chars in s to t
        int[] mapT = new int[256]; // maps chars in t to s

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If either mapping is inconsistent
            if (mapS[c1] == 0 && mapT[c2] == 0) {
                mapS[c1] = c2;
                mapT[c2] = c1;
            } else if (mapS[c1] != c2 || mapT[c2] != c1) {
                return false;
            }
        }
        return true;
    }
}