class Solution {
    public void sortInWave(int arr[]) {
        // code here if input is unsorted
        Arrays.sort(arr);
        
        for(int i = 0; i<arr.length-1; i +=2){
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }
    }
}
