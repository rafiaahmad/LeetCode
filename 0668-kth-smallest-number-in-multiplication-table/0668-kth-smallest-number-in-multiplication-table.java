class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m*n;

        //Search space for binary search
        while(low < high){
        int mid = low + (high-low)/2;

        if(countLessOrEqual(mid, k, m, n))
            high = mid;
        else
            low = mid + 1;
        }
        return low; //or high ans converge at this point
    }

    public boolean countLessOrEqual(int target, int k, int m, int n){
        int cnt = 0;
        // int row = 1, col = n;

        // //search space for counting elements <= target
        // while(row <= m && col >= 1){
        //     if(row*col > target)
        //         col--; // Skip all ele. of current col. > target
        //     else{
        //         cnt += col; //count all el. of current row <= target
        //         row++; //proceed in next column
        //     }
        // }
        for(int i=1; i<=m; i++){
            cnt += Math.min(n, target/i);
        }

        return (cnt>=k);
    }
}