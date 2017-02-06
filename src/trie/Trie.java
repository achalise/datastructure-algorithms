package trie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by achalise on 6/2/17.
 */
public class Trie {
    private TrieNode root = new TrieNode();

    public void put(String key) {
        int index = 0;
        put(key, root, index);
    }

    private void put(String key, TrieNode root, int index) {
        if(index == key.length()) {
            root.setWord(true);
            return;
        }
        char c = key.charAt(index);
        TrieNode current = root.getMap().get(c);

        if(current == null) {
            root.getMap().put(c, new TrieNode(c));
            current = root.getMap().get(c);
        }
        put(key, current, ++index);
    }

    public boolean isAWord(String word) {
        int index = 0;
        TrieNode node = root;
        while(index < word.length()) {
            char c = word.charAt(index++);
            node = node.getMap().get(c);
            if(node == null) {
                return false;
            }
        }
        return node.isWord();

    }

    public void delete(String key) {

    }

    public void print() {
        print(root, "");
    }

    private void print(TrieNode node, String stringSoFar) {
        if(node.isWord()) {
            System.out.println(stringSoFar + Character.toString(node.getKey()));
        }
        stringSoFar = stringSoFar + node.getKey();
        Collection<TrieNode> nodes = node.getMap().values();
        for(TrieNode n: nodes) {
            print(n, stringSoFar);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.put("name");
        trie.put("nepal");
        trie.put("state");
        trie.put("neuron");
        trie.put("storm");
        trie.put("sugar");
        trie.print();

        System.out.println("Is 'name' a word: " + trie.isAWord("name"));
        System.out.println("Is 'nam' a word: " + trie.isAWord("nam"));
    }

}

class TrieNode {
    private char key;
    private Map<Character, TrieNode> map = new HashMap<>();
    private boolean isWord;

    TrieNode() {
        this.map = new HashMap<>();
    }

    TrieNode(char c) {
        this.key = c;
        this.map = new HashMap<>();
    }

    public Map<Character, TrieNode> getMap() {
        return this.map;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public char getKey() {
        return this.key;
    }
}