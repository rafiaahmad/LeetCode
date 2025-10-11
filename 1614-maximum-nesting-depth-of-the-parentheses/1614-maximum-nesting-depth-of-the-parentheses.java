class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int cnt = 0;

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' ){
                // stack.push(ch);
                cnt++;
                maxDepth = Math.max(maxDepth, cnt);
            } else if( ch == ')'){
                // if(!stack.isEmpty()){
                    // stack.pop();
                    cnt--;
                // }                    
            }
        }

        return maxDepth;
    }
}