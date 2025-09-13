class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a hashmap of Roman symbols and values
        HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int total = 0;
            int prevValue = 0;

            //Step2: Traverse right to left
            for(int i=s.length()-1; i>=0; i--){
                int currValue = map.get(s.charAt(i));

                //Step3: Decide whether to add or subtract
                if(currValue < prevValue)
                    total -= currValue; //Subtract if smaller than previous
                else
                    total += currValue; //otherwise, add
                
                prevValue = currValue; //update previous value
            }

            return total;
    }
}