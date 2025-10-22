class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        long num = 0;
        
        // Step 1 : Skip leading spaces
        while(i<n && s.charAt(i) == ' ') i++;

        // Step 2 : Check the sign
        if(i < n){
            if(s.charAt(i) == '+') { sign = 1; i++;}
            else if (s.charAt(i) == '-') { sign = -1; i++;}
        }

        // Step 3 : Read digits
        while(i < n && Character.isDigit(s.charAt(i) )){
            int digit = s.charAt(i) - '0';
            num = num*10 + digit;

            // Step 4: Check overflow
            if(sign*num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign*num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * num);
    }
}