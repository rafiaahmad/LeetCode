class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int i = 0;

        while (i < n) {

            char current = chars[i];
            int count = 0;

            // count group length
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // write character
            chars[write++] = current;

            // write count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}