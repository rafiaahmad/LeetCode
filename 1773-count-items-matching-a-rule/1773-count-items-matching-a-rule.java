class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleKeyIndex = 0;

        //Map ruleKey to index
        if(ruleKey.equals("type")) ruleKeyIndex = 0;
        else if(ruleKey.equals("color")) ruleKeyIndex = 1;
        else if(ruleKey.equals("name")) ruleKeyIndex = 2;

        int count = 0;

        //Iterate and count matches
        for(List<String> item : items){
            if (item.get(ruleKeyIndex).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}