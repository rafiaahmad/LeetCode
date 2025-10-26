class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        // Approach 1 : TC : O(1) -- loop executing 12*60 = 720 times which is O(1)
        // Space complexity: O(1)
        
        int bitCount = 0;
        List<String> list = new ArrayList<>();

        //Loop for hrs, minute calculation
        for(int hour = 0; hour < 12; hour++ ){
            for(int second = 0; second < 60; second++){
                int totalOn = Integer.bitCount(hour) + Integer.bitCount(second);

                if(totalOn == turnedOn)
                    list.add(hour + ":" + String.format("%02d",second));
            }
        }

        return list;
    }
}