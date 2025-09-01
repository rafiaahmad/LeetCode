class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int start = 0, end = arr.length - 1;
        int floor = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] <= x){
                floor = mid;
                start = mid + 1;
            } else{
                end = mid -1;
            }
        }
        return floor;
    }
}
