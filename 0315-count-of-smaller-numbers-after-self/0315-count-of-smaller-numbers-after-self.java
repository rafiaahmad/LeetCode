class Pair{
    int val;
    int index;

    Pair(int v, int i){
        val = v;
        index = i;
    }
}

class Solution {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        List <Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        Pair[] arr = new Pair[n];

        //Step 1: Populate value index in array of Pair type
        for(int i = 0; i<n; i++)
            arr[i] = new Pair(nums[i], i);

        //Step 2: Call MergeSort functions
        mergeSort(arr, 0, n-1, result);
        return result;
    }

    public static void mergeSort(Pair[] arr, int left, int right, List<Integer>
    result){
        if(left>=right) return;
        int mid = left + (right-left)/2;

        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid+1, right, result);
        merge(arr, left, mid, right, result);
    }

    public static void merge(Pair[] arr, int left, int mid, int right, List<Integer> result){
        List<Pair> tmp = new ArrayList<>();
        int i = left, j = mid + 1;
        int rightCount = 0;

        while(i<=mid && j<=right){
            if(arr[i].val <= arr[j].val){
                result.set(arr[i].index, result.get(arr[i].index) + rightCount);
                tmp.add(arr[i++]);
            } else{
                rightCount++;
                tmp.add(arr[j++]);
            }
        }

        while(i<=mid){
            result.set(arr[i].index, result.get(arr[i].index)+rightCount);
            tmp.add(arr[i++]);
        }

        while(j<=right) 
            tmp.add(arr[j++]);

        for(int k = 0; k<tmp.size(); k++)
            arr[left+k] = tmp.get(k);
    }
}
