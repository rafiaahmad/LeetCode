class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        
        // Step 1 : Find the potential celebrity
        int candidate = 0;
        
        for(int i = 1; i < n; i++){
            if(mat[candidate][i] == 1)
                candidate = i; // candidate know i -> candidate cannot be celebrity
        }
        
        // Step 2 : Verify candidate
        for(int i = 0; i < n; i++){
            if(i != candidate){
                // Candidate should not know anyone
                // Everyone should know candidate
                if(mat[candidate][i] == 1 || mat[i][candidate] == 0)
                    return -1;
            }
        }
        
        return candidate;
    }
}