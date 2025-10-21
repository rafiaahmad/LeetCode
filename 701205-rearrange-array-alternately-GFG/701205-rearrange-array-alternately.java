class Solution {
    public void rearrange(int arr[]) {
        // code here
        Arrays.sort(arr);
        int n =  arr.length;
        int minIndex = 0, maxIndex = n-1;
        int maxElement = arr[n-1]+1;
        
        for(int i = 0; i<n; i++){
            if(i%2 == 0){
                //Even index --> place maximum
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else{
                // Odd Index --> place minimum
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }
        
        for (int i = 0; i < n; i++){
            arr[i] = arr[i] / maxElement;
        }
    }
}
