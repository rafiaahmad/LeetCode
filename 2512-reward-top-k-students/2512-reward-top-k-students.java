class Solution {
    public List<Integer> topStudents(
            String[] positive_feedback,
            String[] negative_feedback,
            String[] report,
            int[] student_id,
            int k) {

        Set<String> pos = new HashSet<>();
        Set<String> neg = new HashSet<>();

        for (String s : positive_feedback) pos.add(s);
        for (String s : negative_feedback) neg.add(s);

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < report.length; i++) {
            int score = 0;
            String[] words = report[i].split(" ");

            for (String w : words) {
                if (pos.contains(w)) score += 3;
                else if (neg.contains(w)) score -= 1;
            }

            list.add(new int[]{score, student_id[i]});
        }

        // Sort by score desc, id asc
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i)[1]);
        }
        return result;
    }
}