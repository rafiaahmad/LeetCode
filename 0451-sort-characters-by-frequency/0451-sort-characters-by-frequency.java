class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[62]; // for frequency counting
        for(char ch : s.toCharArray()){
            // Step 1 : Map frequencies
            int index;
            if(ch >= '0' && ch <= '9') index = ch - '0';
            else if(ch >= 'a' && ch <= 'z') index = ch - 'a' + 36;
            else index = ch - 'A' + 10;

            // Step 2 : count the frequency
            freq[index]++;
        }

        // Step 3 : Prepare bucket
        int n = s.length();
        List<Character>[] bucket = new List[n+1];

        for(int i = 0; i<=n; i++)
            bucket[i] = new ArrayList<>();

        //Add characters to bukcet
        for(int i = 0; i<62; i++){
            if(freq[i] > 0)
                bucket[freq[i]].add(charForIndex(i)); // convert index back to char
        }

        // Step 4 : Prepare result
        StringBuilder result = new StringBuilder();
        for(int f = n; f>=1; f--){
            for(char ch : bucket[f]){
                for(int k = 0; k<f; k++)
                    result.append(ch);
            }
        }

        return result.toString(); // return result
    }

    public char charForIndex(int index){
        if(index < 10) return (char)('0' + index);
        else if(index < 36) return (char) ('A' + (index - 10));
        else return (char)('a' + (index - 36));
    }
}