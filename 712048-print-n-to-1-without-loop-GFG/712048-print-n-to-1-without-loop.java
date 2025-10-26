class Solution {

    void printNos(int N) {
        // T.C: O(N), SC: O(N)
        if(N == 0) return;
        System.out.print(N + " ");
        printNos(--N);
    }
}