class Solution {
    public int countSubstr(String s, int k) {
        
        if(k == 0) return 0;
        
        return countAtMostk(s, k) - countAtMostk(s, k-1);
    }
    
    public int countAtMostk(String s, int k){
        if(k<0) return 0;
        
        int n = s.length();
        int[] freq = new int[26];
        int start = 0;
        int distinctCount = 0;
        int finalCount = 0;
        
        for(int end = 0; end < n; end++){
            char ch = s.charAt(end);
            freq[ch-'a']++;
            if(freq[ch-'a'] == 1) distinctCount++;
            
            //Shrink window until distinctCount <= k
            while(distinctCount > k){
                char removeChar = s.charAt(start);
                freq[removeChar - 'a']--;
                
                if(freq[removeChar - 'a'] == 0) 
                    distinctCount--;
                start++;
            }
            
    // all substrings ending at right with start in [start..end] are valid
            finalCount += (end-start+1);
        }
        
        return finalCount;
    }
}