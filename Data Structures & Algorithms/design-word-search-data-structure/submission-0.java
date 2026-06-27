class TrieNode {

    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode curr) {

        if (index == word.length())
            return curr.isWord;

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {

            if (!curr.children.containsKey(ch))
                return false;

            return search(word, index + 1, curr.children.get(ch));
        }

        // Wildcard '.'
        for (TrieNode child : curr.children.values()) {

            if (search(word, index + 1, child))
                return true;
        }

        return false;
    }
}