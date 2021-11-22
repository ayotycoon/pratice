package fireCode;

import java.util.HashMap;

class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
    public TrieNode(Character c) {
        this.c = c;
    }
}

public class Trie {
    // java.util.* and java.util.streams.* have been imported for this problem.
    // You don't need any other imports.

        private static TrieNode root;

        // Implement these methods :
        public Trie() {}
        public static void insertWord(String word) {
            if(word == null) return;
            if(root == null) root = new TrieNode();
            TrieNode ref = root;
            int wordLen = word.length();
            for(int i =0; i < wordLen; i++){
                Character c = word.charAt(i);

                if(ref.children.get(c) != null){
                    ref = ref.children.get(c);

                    continue;
                }
                TrieNode t = new TrieNode();

                if(i == wordLen-1){
                    t.isLeaf = true;
                }

                ref.children.put(c, t);


                ref = t;
            }



        }
        public static Boolean searchWord(String word) {
            if(word == null) return false;
            if(root == null) return false;
            TrieNode ref = root;
            for(int i =0; i < word.length(); i++){

                Character c = word.charAt(i);

                if(ref.children.get(c) == null){
                    return false;
                }

                ref = ref.children.get(c);
            }

            return ref.isLeaf;

        }
        public static Boolean searchPrefix(String word) {

            if(word == null) return false;
            if(root == null) return false;
            for(int i =0; i < word.length(); i++){
                Character c = word.charAt(i);

                if(root.children.get(c) == null){
                    return false;
                }

                root = root.children.get(c);
            }

            return true;



    }

    public static void main (String[] args){
        insertWord("AYO");

        System.out.println(searchWord("AYO"));
    }
}
