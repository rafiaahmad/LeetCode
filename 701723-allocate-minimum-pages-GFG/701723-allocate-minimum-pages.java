class Solution {
    public int findPages(int[] arr, int k) {
        //return if its not possible to allocate books to all students
        if(arr.length < k) return -1;
        
        //Search space for Binary search
        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        int res = -1;
        
        int low = max;
        int high = sum;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            
            // Search if possible to allocate all books among k student 
            // with atmost k #of pages
            if(isValid(arr, k, mid)){
                res = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return res;
    }
    
    static boolean isValid(int[] arr, int k, int page){
        int cnt = 1;
        int sumPage = 0;
        
        for(int i = 0; i<arr.length; i++){
           
            if(sumPage + arr[i] > page){
                cnt++;
                sumPage = arr[i];
            } else{
                sumPage += arr[i];
            }
            if(cnt > k) return false;
        }
        // return (cnt<=k);
        return true;
    }
}