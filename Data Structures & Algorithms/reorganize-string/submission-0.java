class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        // Max heap: character with highest frequency comes first
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                return y[1] - x[1];
            }
        });
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[] {i, freq[i]});
            }
        }
        StringBuilder result = new StringBuilder();
        int[] previous = null;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            // Use this character
            result.append((char) (current[0] + 'a'));
            current[1]--;

            // Reinsert the previous character only after using
            // a different character
            if (previous != null && previous[1] > 0) {
                pq.offer(previous);
            }
            previous = current;
        }
        // If characters remain unused, rearrangement is impossible
        if (result.length() != s.length()) {
            return "";
        }
        return result.toString();
    }
}