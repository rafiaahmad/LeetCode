class Solution {

    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        backtrack(s.toCharArray(), 0);

        return result;
    }

    private void backtrack(char[] arr, int index) {

        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }

        // digit → continue
        if (Character.isDigit(arr[index])) {

            backtrack(arr, index + 1);

            return;
        }

        // lowercase
        arr[index] = Character.toLowerCase(arr[index]);
        backtrack(arr, index + 1);

        // uppercase
        arr[index] = Character.toUpperCase(arr[index]);
        backtrack(arr, index + 1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna