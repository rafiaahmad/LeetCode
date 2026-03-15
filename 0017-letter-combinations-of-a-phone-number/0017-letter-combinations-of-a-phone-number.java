class Solution {

    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(result, digits, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, String current, int index) {

        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }

        String letters = map.get(digits.charAt(index));

        for (char c : letters.toCharArray()) {
            backtrack(result, digits, current + c, index + 1);
        }
    }
}