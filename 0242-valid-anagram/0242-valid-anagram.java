class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> freqS = new HashMap<>();
        HashMap<Character, Integer> freqT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            freqS.put(charS, freqS.getOrDefault(charS, 0) + 1);
            freqT.put(charT, freqT.getOrDefault(charT, 0) + 1);
        }

        for(char ch : freqS.keySet()){
            if(!freqT.containsKey(ch)) return false;
            if(!freqS.get(ch).equals(freqT.get(ch))) return false;
        }

        return true;
    }
}