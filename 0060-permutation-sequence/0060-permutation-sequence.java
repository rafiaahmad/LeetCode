class Solution {
    public String getPermutation(int n, int k) {
       // Step 1: factorial array
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = i * fact[i - 1];

        // Step 2: numbers 1..n
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        // Step 3: build permutation
        k--; // convert to 0-based index
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i - 1];
        }
        return sb.toString(); 
    }
}