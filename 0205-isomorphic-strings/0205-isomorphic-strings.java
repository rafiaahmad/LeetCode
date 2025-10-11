class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for(int i = 0; i<s.length() && i< t.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(map.containsKey(charS)){
                if(!map.get(charS).equals(charT))
                    return false; 
            } else{
                if(used.contains(charT)) return false;
                map.put(charS, charT); 
                used.add(charT);
            }
                 
        }
    return true;
    }
}