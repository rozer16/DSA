package n_graph.B_BFS_DFS_Problems;

import java.util.*;

public class H_WordLadder {


    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
       List<String> wordList =  Arrays.asList(
               "des",
               "der",
               "dfr",
               "dgt",
               "dfs"
       );


        ;

        System.out.println(ladderLength(startWord,targetWord,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(beginWord,1);

        queue.offer(p);

        Set<String> strSet = new HashSet<>(wordList);
        strSet.remove(beginWord);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            // we return the steps as soon as
            // the first occurrence of targetWord is found.
            if(pair.getWord().equals(endWord))
                return pair.getLevel();

            String newWord = pair.word;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < newWord.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char [] chars = newWord.toCharArray();
                    chars[i]=j;
                    String newStr = new String(chars);

                    // check if it exists in the set and push it in the queue.
                    if(strSet.contains(newStr)) {
                        queue.offer(new Pair(newStr, pair.getLevel() + 1));
                        strSet.remove(newStr);
                    }
                }
            }
        }
        // If there is no transformation sequence possible
        return 0;
    }


    static class Pair{
        private String word;
        private int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }
}

