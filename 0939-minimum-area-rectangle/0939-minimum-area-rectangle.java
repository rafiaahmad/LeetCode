class Solution {

    public int minAreaRect(int[][] points) {

        Set<String> set = new HashSet<>();

        for (int[] p : points) {
            set.add(p[0] + "#" + p[1]);
        }

        int minArea = Integer.MAX_VALUE;

        int n = points.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                // must form diagonal
                if (x1 == x2 || y1 == y2) {
                    continue;
                }

                // other two corners
                String p3 = x1 + "#" + y2;
                String p4 = x2 + "#" + y1;

                if (set.contains(p3)
                        && set.contains(p4)) {

                    int area =
                        Math.abs(x2 - x1)
                      * Math.abs(y2 - y1);

                    minArea = Math.min(minArea, area);
                }
            }
        }

        return minArea == Integer.MAX_VALUE
                ? 0
                : minArea;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna