class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(); // res list
        Deque<Integer> st = new ArrayDeque<>(); // for building motonic stack
        
        // Step 1 : Traverse the array from right to left
        for(int i = n-1; i>=0; i--){
            // Step 2 : Pop element if current element >= stack top ele.
            while(!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
                
            // Step 3 : Decide Next greater element
            if(st.isEmpty())
                res.add(-1); // stack is empty, no NGE 
            else
                res.add(st.peek()); // NGE available
            
            // Step 4 : Push the current element into stack
            st.push(arr[i]);
        }
        
        Collections.reverse(res); // reverse the result array
        return res;
    }
}