// User function Template for Java
class Solution {

    String reverseEqn(String S) {
        // your code here
        int len = S.length();
        Stack <Character> stack= new Stack<>();
        StringBuilder rev = new StringBuilder(S.length());
        
        for(int i = len-1; i>=0; i--){
            
            char ch = S.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //pop elements from stack and concatenate it to rev. string
                while(!stack.isEmpty()){
                    //pop the elements untill stack become empty
                   rev.append(stack.pop()); 
                }
                rev.append(ch);
                
            } else{
                //Push the character into stack
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()){
                    //pop the elements untill stack become empty
                   rev.append(stack.pop()); 
        }
                
        return rev.toString();
    }
}