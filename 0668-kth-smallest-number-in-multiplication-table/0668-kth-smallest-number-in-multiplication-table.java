class Solution {
    public int findKthNumber(int m, int n, int k) {
        int min = 1, max = m*n;

        while(min<max){
            int mid = min + (max-min)/2;
            int count = bsCountLess(mid, m, n);

            if(count>=k) max = mid;
            else min = mid+1;
        }
        return min;
    }

    static int bsCountLess(int mid, int m, int n){
        int count = 0;
        int row = m, col = 1;

        while(row>=1 && col<=n){
            if(row*col <= mid){
                count += row;
                col++;
            } else{
                row--;
            }
        }
        return count;
    }
}