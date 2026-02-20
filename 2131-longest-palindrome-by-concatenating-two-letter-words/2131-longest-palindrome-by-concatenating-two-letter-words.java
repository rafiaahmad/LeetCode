class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int length = 0;
        boolean centerUsed = false;

        for(String word : map.keySet()) {
            String reverse = new StringBuilder(word).reverse().toString();
            
            if(!word.equals(reverse)) {
                if(map.containsKey(reverse)) {
                    length += 4 * Math.min(map.get(word), map.get(reverse));
                }
            } else {
                int count = map.get(word);
                
                length += (count / 2) * 4;
                
                if(count % 2 == 1) {
                    centerUsed = true;
                }
            }
        }

        if(centerUsed) {
            length += 2;
        }

        return length;
    }
}