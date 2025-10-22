class Solution {
    public String frequencySort(String s) {
        // Step 1 : Count the frequency using HashMap
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        // Step 2 : Create list of entries and sort 
        List<Character> list = new ArrayList<>(freq.keySet());

        //Step 3 : Sort the list
        Collections.sort(list, (a, b) -> freq.get(b) - freq.get(a));

        // Step 4 : Build result Strin and  Append into string
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j<freq.get(list.get(i)); j++)
                result.append(list.get(i)); //append the character as its frequency
        }

        //Step 5 : Return the string
        return result.toString();
    }
}