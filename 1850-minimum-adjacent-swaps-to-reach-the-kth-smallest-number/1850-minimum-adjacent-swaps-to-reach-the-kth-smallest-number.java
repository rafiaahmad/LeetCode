class Solution {
    public int getMinSwaps(String num, int k) {
        char[] original = num.toCharArray();
        char[] target = num.toCharArray();

        // Phase 1: get k-th permutation
        while (k-- > 0) {
            nextPermutation(target);
        }

        // Phase 2: count minimum adjacent swaps
        int swaps = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == target[i]) continue;

            int j = i + 1;
            while (original[j] != target[i]) {
                j++;
            }

            // Bubble left
            while (j > i) {
                char temp = original[j];
                original[j] = original[j - 1];
                original[j - 1] = temp;
                swaps++;
                j--;
            }
        }
        return swaps;
    }

    private void nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        swap(arr, i, j);
        reverse(arr, i + 1);
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void reverse(char[] arr, int start) {
        int i = start, j = arr.length - 1;
        while (i < j) swap(arr, i++, j--);
    }
}