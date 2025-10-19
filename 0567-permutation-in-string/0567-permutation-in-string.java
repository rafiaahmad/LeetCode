class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Step 1: Compare frequency of both s1 ans s2
        HashMap<Character, Integer> freqS1 = new HashMap<>();
        HashMap<Character, Integer> freqS2 = new HashMap<>();

        for(int i = 0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            freqS1.put(ch, freqS1.getOrDefault(ch, 0) + 1);
        }
        
        //Initialize first window
        for(int i = 0; i<s1.length(); i++){
            char ch = s2.charAt(i);
            freqS2.put(ch, freqS2.getOrDefault(ch, 0) + 1);
        }

        //check if first window is elegible
        if(freqS1.equals(freqS2)) return true;

        //Traverse the string s2
        for(int i = s1.length(); i<s2.length(); i++){
            char ch = s2.charAt(i); 
            char prev = s2.charAt(i-s1.length());
            
            freqS2.put(ch, freqS2.getOrDefault(ch, 0)+1);

            freqS2.put(prev, freqS2.get(prev)-1);
            if(freqS2.get(prev) == 0)
                freqS2.remove(prev);

            if(freqS1.equals(freqS2))
            return true;
        }

        return false;
    }
}