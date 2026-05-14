class Solution {

    public boolean isAdditiveNumber(String num) {

        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {

            // leading zero check
            if (num.charAt(0) == '0' && i > 1) break;

            long first = Long.parseLong(num.substring(0, i));

            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {

                // leading zero check
                if (num.charAt(i) == '0' && j > 1) break;

                long second =
                    Long.parseLong(num.substring(i, i + j));

                if (dfs(num, i + j, first, second)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(String num,
                        int start,
                        long first,
                        long second) {

        if (start == num.length()) return true;

        long sum = first + second;

        String sumStr = String.valueOf(sum);

        if (!num.startsWith(sumStr, start)) {
            return false;
        }

        return dfs(
            num,
            start + sumStr.length(),
            second,
            sum
        );
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna