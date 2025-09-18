// User function Template for Java
class Solution {
    static ArrayList<Integer> getTable(int n) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i<10; i++){
            res.add((i+1)*n);
        }
        
        return res;
    }
}