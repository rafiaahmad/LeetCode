class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> uniqueChars = new HashSet<>();

        for(char ch : sentence.toCharArray()){
            uniqueChars.add(ch);
        }

        return uniqueChars.size() == 26;
    }
}