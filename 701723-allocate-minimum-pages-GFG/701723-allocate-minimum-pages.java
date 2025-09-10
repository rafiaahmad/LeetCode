class Solution {
    public int findPages(int[] arr, int k) {
        // if number of students are more than total books
        // then allocation is not possible
        if(k > arr.length) return -1;
        
        //Search space for Binary Search
        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();
        int res = -1; //maximum no. of pages 
        
        while(lo<=hi){
            int pageLimit = lo + (hi-lo)/2;
            
            if(isValid(arr, k, pageLimit)){
                res = pageLimit;
                hi = pageLimit - 1;
            } else{
                lo = pageLimit + 1;
            }
        }
        return res;
    }
    
    
    // function to check if books can be allocated to
    // all k students without exceeding 'pageLimit'
    static boolean isValid(int[] arr, int k, int pageLimit){
        
         // starting from the first student
        int pageSum = 0;
        int cntStudent = 1;
        
        
        for(int i = 0; i<arr.length; i++){
        
        // if adding the current book exceeds the page 
        // limit, assign the book to the next student
        if(pageSum + arr[i] > pageLimit){
            cntStudent++;
            pageSum = arr[i];
        } else{
            pageSum += arr[i];
        }
        
        //early exit if count of student becomes more than k
        // if(cntStudent > k) return false;
        }
        return (cntStudent <=k);
    }
}