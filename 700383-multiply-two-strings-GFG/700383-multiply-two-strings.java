class Solution {
    public String multiplyStrings(String s1, String s2) {
        
        //check the string is positive or negative
        boolean neg1 = (s1.charAt(0) == '-');
        //remove negative sign for calculation
        if(neg1) s1 = s1.substring(1);
        
        boolean neg2 = (s2.charAt(0) == '-');
        //remove negative sign for calculation
        if(neg2) s2 = s2.substring(1);
        
        //remove leading zeros
        s1 = removeLeadingZeroes(s1);
        s2 = removeLeadingZeroes(s2);
        
        // If either is zero, return "0"
        if (s1.equals("0") || s2.equals("0")) return "0";
        
        //check the result will be positive or negative
        boolean resultNegative = (neg1 ^ neg2);
        
        //array to store the result
        int n1 = s1.length();
        int n2 = s2.length();
        int[] result = new int[n1 + n2];
        
        //go from right to left for string s1
        for(int i = n1-1; i>=0; i--){
            
            //take the value of string ith character into integer
            int n1Digit = s1.charAt(i) - '0';
            
            //go from right to left for string s2
            for(int j=n2-1; j>=0; j--){

                //take the value of string ith character into integer
                int n2Digit = s2.charAt(j) - '0';
                
                //Store the multiple, plus previous result if available
                int sum = n1Digit*n2Digit + result[i+j+1];
                
                //Store the result in Least Significant
                result[i+j+1] = sum % 10;
                
                //Store carry before result index
                result[i+j] += sum / 10;
            }
        }
        
        //convert result array to String
        StringBuilder res = new StringBuilder();
        for(int r : result){
            if(!(res.length() == 0 && r == 0))
                res.append(r);
        }
        
         // Add negative sign if needed
        if (resultNegative) res.insert(0, '-');
        
        // conver res to string and return result
        return res.toString();
    }
    
    public String removeLeadingZeroes(String s){
        int i = 0;
        while(i<s.length() && s.charAt(i) == '0') i++;
        return (i == s.length()) ? "0" : s.substring(i);
    }
}