class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m*n;

        //Search space for binary search
        while(low < high){
        int mid = low + (high-low)/2;

        if(countLessOrEqual(mid, k, m, n))
            high = mid; //Search kth smallest <= mid
        else
            low = mid + 1; //Search Kth smalles > mid
        }
        return low; //or high ans converge at this point
    }

    public boolean countLessOrEqual(int target, int k, int m, int n){
        int cnt = 0;
        for(int i=1; i<=m; i++){
            // target/i gives the count of ele. <= target in ith row
            cnt += Math.min(n, target/i);
        }

        return (cnt>=k); // return true if count >= k
    }
}