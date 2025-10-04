class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count++; // go one level deeper
                max = Math.max(max, count);
            } else if(ch == ')'){
                count--; //come one level up
            }
        }
        return max;
    }
}