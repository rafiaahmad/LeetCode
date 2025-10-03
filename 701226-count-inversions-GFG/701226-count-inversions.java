class Solution {
    static int inversionCount(int arr[]) {
        return countInv(arr, 0, arr.length-1);
    }
    
    static int countInv(int[] arr, int left, int right){
        int InverseCount = 0;
        
        if(left < right){
            int mid = left + (right-left)/2;
            
            //Count Inversion in left half
            InverseCount += countInv(arr, left, mid);
            
            //Count Inversion in right half
            InverseCount += countInv(arr, mid+1, right);
            
            //Count Inversion while merging where
            //ele. of left half > ele. of right half
            InverseCount += MergeAndCountInv(arr, left, mid, right);
        }
        
        return InverseCount;
    }
    
    static int MergeAndCountInv(int[] arr, int left, int mid, int right){
        //Step 1: Copy into n/2 arrays into half parts in 2 arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int cnt = 0;
        
        int[] Left = new int[n1];
        int[] Right = new int[n2];
        
        for(int i = 0; i<n1; i++)
            Left[i] = arr[left+i];
            
        for(int i = 0; i<n2; i++)
            Right[i] = arr[mid+1+i];
           
        //Step 2: Compare, sort and count inversion if comes
        int i = 0, j = 0, k = left;
        
        while(i<n1 && j<n2){
            if(Left[i] <= Right[j])
                arr[k++] = Left[i++];
            else{
                arr[k++] = Right[j++];
                cnt += n1 - i; //Inversion pair found increase count
            }
        }
        
        while(i<n1) arr[k++] = Left[i++];
        while(j<n2) arr[k++] = Right[j++];
        
        return cnt;
    }
}