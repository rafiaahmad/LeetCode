class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Complexity: t.c : O(1), s.c: O(1)
        int[] d = new int[] {
            dist(p1, p2),
            dist(p1, p3),
            dist(p1, p4),
            dist(p2, p3),
            dist(p2, p4),
            dist(p3, p4)
        };

        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : d) {

            if (x == 0) return false;

            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // must have exactly:
        // 4 equal sides + 2 equal diagonals
        return freq.size() == 2
            && freq.containsValue(4)
            && freq.containsValue(2);
    }

    private int dist(int[] a, int[] b) {

        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna