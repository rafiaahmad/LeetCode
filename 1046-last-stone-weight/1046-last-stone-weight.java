class Solution {
    public int lastStoneWeight(int[] stones) {

        // Store the stones into list
        List<Integer> list = new ArrayList<>();
        for(int s : stones) list.add(s);

        // Do while 1 stone left
        while(list.size() > 1){
            Collections.sort(list); // Sort so that last two are heaviest

            int y = list.remove(list.size() - 1); // heaviest
            int x = list.remove(list.size() - 1); // second heaviest

            if(x != y)
                list.add(y-x); // push back the new stone
        }

        return list.isEmpty() ? 0 : list.get(0);
    }
}
