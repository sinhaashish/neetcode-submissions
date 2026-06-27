

class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
    String word;
}

class Solution {

    TrieNode root = new TrieNode();

    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words)
            insert(word);

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            curr.children.putIfAbsent(ch, new TrieNode());

            curr = curr.children.get(ch);
        }

        curr.isWord = true;
        curr.word = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {

        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] == '#')
            return;

        char ch = board[i][j];

        if (!node.children.containsKey(ch))
            return;

        node = node.children.get(ch);

        if (node.isWord) {

            result.add(node.word);

            // Prevent duplicates
            node.isWord = false;
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node);
        dfs(board, i - 1, j, node);
        dfs(board, i, j + 1, node);
        dfs(board, i, j - 1, node);

        board[i][j] = ch;
    }
}