class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generate(sb, 0, 0, n, res);
        return res;
    }

    public void generate(StringBuilder sb, int open, int close, int max, List<String> res){
        if(sb.length() == 2*max){
            res.add(sb.toString());
            return;
        }

        if(open < max){
            sb.append('(');
            generate(sb, open+1, close, max, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            sb.append(')');
            generate(sb, open, close+1, max, res);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}