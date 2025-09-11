class Solution {
    public void sortInWave(int arr[]) {
        // code here
        int n  = arr.length;
        if(n%2 == 0){
            for(int i = 0; i<n; i +=2){
                //swap each element
                int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
            }
        } else{
            for(int i=0; i<n-1; i +=2){
                //swap each element except last element
                int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
            }
        }
    }
}
