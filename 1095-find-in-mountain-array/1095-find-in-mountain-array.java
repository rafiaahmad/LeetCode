/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr); // find peak element
        //Check peak directly
        if(mountainArr.get(peak) == target) return peak;

        //Search in Left (Descending part)
        int left = binarySearch(mountainArr, 0, peak-1, target, false);
        if(left != -1) return left;

        //Search in Right (Ascending part)
        return binarySearch(mountainArr, peak+1, mountainArr.length()-1, target,true);
    }

    //find Peak element index    
    static int findPeak(MountainArray arr){
        int start = 0, end = arr.length()-1;
        while(start < end){
            int mid = start + (end-start)/2;
      
            if(arr.get(mid) < arr.get(mid+1)){
                start = mid+1;
            } else{
                end = mid;
            }
        }
        return start;
    }

    static int binarySearch(MountainArray arr, int start, int end, int target, boolean isAsc){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr.get(mid) == target) return mid;

            if(isAsc){
                if(arr.get(mid) > target) end = mid-1;
                else start = mid+1;
            } else{ //Descending
                if(arr.get(mid) < target) start = mid+1 ;
                else end = mid-1;
            }
        }
        return -1;
    }
}