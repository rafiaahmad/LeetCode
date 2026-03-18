class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if(!dict.contains(endWord)) return result;

        Map<String, List<String>> parentMap = new HashMap<>();

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;

        while(!currentLevel.isEmpty() && !found){

            Set<String> nextLevel = new HashSet<>();

            for(String word : currentLevel){
                dict.remove(word);
            }

            for(String word : currentLevel){

                char[] arr = word.toCharArray();

                for(int i = 0; i < arr.length; i++){

                    char original = arr[i];

                    for(char c = 'a'; c <= 'z'; c++){

                        arr[i] = c;
                        String newWord = new String(arr);

                        if(dict.contains(newWord)){

                            nextLevel.add(newWord);

                            parentMap
                                .computeIfAbsent(newWord, k -> new ArrayList<>())
                                .add(word);

                            if(newWord.equals(endWord)){
                                found = true;
                            }
                        }
                    }

                    arr[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        if(found){
            List<String> path = new ArrayList<>();
            backtrack(endWord, beginWord, parentMap, path, result);
        }

        return result;
    }

    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> parentMap,
                           List<String> path,
                           List<List<String>> result){

        if(word.equals(beginWord)){
            path.add(word);
            Collections.reverse(path);
            result.add(new ArrayList<>(path));
            Collections.reverse(path);
            path.remove(path.size()-1);
            return;
        }

        path.add(word);

        if(parentMap.containsKey(word)){
            for(String parent : parentMap.get(word)){
                backtrack(parent, beginWord, parentMap, path, result);
            }
        }

        path.remove(path.size()-1);
    }
}