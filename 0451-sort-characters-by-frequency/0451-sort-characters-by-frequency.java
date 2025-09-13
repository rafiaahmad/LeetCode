class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Put all characters into a list
        List<Character> list = new ArrayList<>(freq.keySet());

        // Step 3: Sort characters by frequency (descending)
        Collections.sort(list, (a, b) -> freq.get(b) - freq.get(a));

        // Step 4: Build result string
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}