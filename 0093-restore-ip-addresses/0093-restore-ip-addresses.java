class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        generate(0, s, new ArrayList<>(), res);
        return res;
    }

    private void generate(int index, String s, List<String> current, List<String> res){
        //Base Case: If 4 segments collected and string fully used → valid IP
        if(current.size() == 4){
            if(index == s.length())
                res.add(String.join(".", current));
            return;
        }

        //Try segment of length 1, 2, and 3
        for(int len = 1; len<=3; len++){
            if(index+len > s.length())  break;

            String segment = s.substring(index, index+len);

            if(isValid(segment)){
                current.add(segment);
                generate(index+len, s, current, res);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isValid(String segment){
        if(segment.length() > 1 && segment.charAt(0) == '0') return false;
        int val = Integer.parseInt(segment);
        return val>=0 && val<=255;
    }
}