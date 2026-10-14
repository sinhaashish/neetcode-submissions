class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        // Store the position of each character in alien alphabet
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }
        // Compare every adjacent pair of words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int j = 0;
            int minLength = Math.min(w1.length(), w2.length());
            // Find the first position where characters differ
            while (j < minLength) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    if (rank[c1 - 'a'] > rank[c2 - 'a']) {
                        return false;
                    }
                    // First differing character decides the order
                    break;
                }
                j++;
            }
            // If w2 is a prefix of w1, the order is invalid
            if (j == minLength && w1.length() > w2.length()) {
                return false;
            }
        }

        return true;
    }
}