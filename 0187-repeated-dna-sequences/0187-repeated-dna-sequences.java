class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> result = new ArrayList<>();
        
        if(n < 10) return result;
        
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        
        for(int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            
            if(!seen.add(sub)) {
                repeated.add(sub);
            }
        }
        
        result.addAll(repeated);
        return result;
    }
}