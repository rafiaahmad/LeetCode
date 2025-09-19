class Solution {
    public int addDigits(int num) {
        int sum = num;
        while(num>9){
            sum = 0;
            while(num>0){
                int tmp = num%10;
                sum += tmp;
                num /=10;
            }
            num = sum;
        }
        return sum;
    }
}