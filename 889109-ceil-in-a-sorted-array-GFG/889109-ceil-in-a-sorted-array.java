// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int start = 0, end = arr.length-1;
        int ceil = -1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            // if(arr[mid] == x) return mid;
            if(arr[mid] >= x){
                ceil = mid;
                end = mid - 1;
            } else if(arr[mid] < x){
                start = mid + 1;
            }
        }
        return ceil;
    }
}
