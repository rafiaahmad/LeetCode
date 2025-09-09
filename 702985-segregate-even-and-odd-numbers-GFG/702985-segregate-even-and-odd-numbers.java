class Solution {
    void segregateEvenOdd(int arr[]) {
        int n = arr.length;
        int left = 0, right = n - 1;

        // Step 1: Segregate even and odd using two pointers
        while (left < right) {
            // Move left forward if arr[left] is even
            while (left < right && arr[left] % 2 == 0) left++;
            
            // Move right backward if arr[right] is odd
            while (left < right && arr[right] % 2 != 0) right--;
            
            if (left < right) {
                // Swap odd at left with even at right
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        // After segregation, find the boundary between evens and odds
        int evenEnd = 0;
        while (evenEnd < n && arr[evenEnd] % 2 == 0) evenEnd++;

        // Step 2: Sort even part
        Arrays.sort(arr, 0, evenEnd);

        // Step 3: Sort odd part
        Arrays.sort(arr, evenEnd, n);
    }
}