class Solution {
    static int inversionCount(int arr[]) {
        // Function to count the Inversions in the array 
        return countInv(arr, 0, arr.length-1);
    }
    
    // Recursive merge sort function
    static int countInv(int[] arr, int l, int r){
        int res = 0;
        
        if(l<r){
            int mid = l + (r-l)/2;
            
            //count Inversions in left half
            res += countInv(arr, l, mid);
            
            //count Inversions in right half
            res += countInv(arr, mid+1, r);
            
            //count the Inversions where 
            //element of left half is greater than element of right half
            res += MergeandCount(arr, l, mid, r);
        }
        return res;
    }
    
    // Merge two halves and count inversions
    static int MergeandCount(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        
        //array to store left half and right half elemet to merge
        int[] Left = new int[n1];
        int[] Right = new int[n2];
        
        //copy the element int left half and right halve arrays
        for(int i=0; i<n1; i++) Left[i] = arr[i+l];
        for(int j=0; j<n2; j++) Right[j] = arr[mid+1+j];
        
        //compare and sort and shift in original array
        int i = 0, j = 0, k = l;
        int res = 0;
        
        while(i<n1 && j<n2){
            if(Left[i] <= Right[j]){ // No inversion
                arr[k++] = Left[i++];
            } else{     //Count Inversion
                arr[k++] = Right[j++];
                res += (n1-i);
            }
        }
        
        while(i<n1) arr[k++] = Left[i++];
        while(j<n2) arr[k++] = Right[j++];
        
        return res;
    }
}