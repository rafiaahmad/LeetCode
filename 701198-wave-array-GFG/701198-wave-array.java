class Solution {
    public void sortInWave(int arr[]) {
        for(int i = 1; i<arr.length; i += 2){ 
          int tmp = arr[i];
          arr[i] = arr[i-1];
          arr[i-1] = tmp;
        }
    }
    
    // private void swap(int a , int b){
    //     a = a+b;
    //     b = a-b;
    //     a = a-b;
    // }
}
