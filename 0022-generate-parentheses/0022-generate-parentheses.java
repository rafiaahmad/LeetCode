class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();

       generate(res, "", 0, 0, n);
       return res;
    }

    private void generate(List<String> res, String curr, int open, int close, int max){
        //Base Case
        if(curr.length() == 2*max){
            res.add(curr);
            return;
        }

        if(open < max)
            generate(res, curr+"(", open+1, close, max);
        if(close < open)
            generate(res, curr+")", open, close+1, max);
    }
}