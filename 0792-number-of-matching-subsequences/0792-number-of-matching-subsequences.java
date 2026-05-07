class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        Map<Character, List<Integer>> map = new HashMap<>();

        // preprocess positions
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        int count = 0;

        for (String word : words) {
            if (isSubsequence(word, map)) {
                count++;
            }
        }

        return count;
    }

    private boolean isSubsequence(String word,
                                  Map<Character, List<Integer>> map) {

        int prevIndex = -1;

        for (char c : word.toCharArray()) {

            if (!map.containsKey(c)) return false;

            List<Integer> indices = map.get(c);

            int nextPos = upperBound(indices, prevIndex);

            if (nextPos == indices.size()) return false;

            prevIndex = indices.get(nextPos);
        }

        return true;
    }

    // first index > target
    private int upperBound(List<Integer> list, int target) {

        int left = 0, right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}