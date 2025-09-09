class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
     int maxCandies = 0;
     //Find Maximum no. of candies
     for(int candy: candies){
        if(candy > maxCandies){
            maxCandies = candy;
        }
     }
    List<Boolean> res = new ArrayList<>(candies.length);
    //Check if maxCandies< after adding extraCandies for each kids & store result in bool arr
    for(int candy: candies){
        if(maxCandies <= candy + extraCandies){
            res.add(true);
        } else{
            res.add(false);
            }
        }
    return res;
    }
}