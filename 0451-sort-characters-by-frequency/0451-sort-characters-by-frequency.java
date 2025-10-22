class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();

        // Step 1 : Count the frequency using HashMap
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        // Step 2 : Create list of entries and sort 
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());

        //Step 3 : Sort the list
        list.sort((a , b ) -> {
            if(!b.getValue().equals(a.getValue()))
                return b.getValue() - a.getValue(); //higher frequency first
            else
                return a.getValue() - b.getValue();
        });

        // Step 4 : Append into string
        for(int i = 0; i < list.size(); i++){
            //get the ith key
            char ch = list.get(i).getKey();
            for(int j = 0; j<list.get(i).getValue(); j++)
                result.append(ch); //append the character as its frequency
        }

        //Step 5 : Return the string
        return result.toString();
    }
}