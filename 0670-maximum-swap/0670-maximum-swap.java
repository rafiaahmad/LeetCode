class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        // record last occurrence of each digit
        int[] last = new int[10];
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        // try to swap
        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // swap
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;

                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}