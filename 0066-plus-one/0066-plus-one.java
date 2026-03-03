class Solution {
    public int[] plusOne(int[] digits) {
        int num = 0;

        for(int x : digits)
            num = num*10 + x;

        num++;

        ArrayList<Integer> res = new ArrayList<>();
        while(num > 0){
            res.add(num % 10);
            num /= 10;
        }

        Collections.reverse(res);

        int[] result = new int[res.size()];
        int i = 0;
        for(int x : res)
            result[i++] = x;

        return result;
    }
}