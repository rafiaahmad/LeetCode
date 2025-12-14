class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
                
            if(st.isEmpty())
                res.add(-1);
            else
                res.add(st.peek());
            st.push(arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}