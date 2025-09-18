class Solution {
    public static void print_divisors(int n) {
        // code here
        // for(int i=1; i<=n; i++){
        //     if(n%i == 0)
        //         System.out.print(i+ " ");
        // }
        for(int i=1; i<Math.sqrt(n); i++){
            if(n%i == 0)
                System.out.print(i+ " ");
        }
        int sqrt = (int) Math.sqrt(n);
        for( int j = sqrt; j>0; j--){
            if(n%j == 0)
                System.out.print((n/j)+ " ");
        }
    }
}
