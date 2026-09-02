class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);

        Map<Integer, List<String>> memo = new HashMap<>();

        return backtrack(s, 0, dict, memo);
    }

    private List<String> backtrack(
        String s,
        int start,
        Set<String> dict,
        Map<Integer, List<String>> memo
    ) {

        // Already solved
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        // Reached end
        if (start == s.length()) {
            result.add("");
            return result;
        }

        // Try every possible word
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (!dict.contains(word)) {
                continue;
            }

            // Choose
            List<String> remaining =
                backtrack(s, end, dict, memo);

            // Combine
            for (String sentence : remaining) {

                if (sentence.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(word + " " + sentence);
                }
            }
        }

        memo.put(start, result);

        return result;
    }
}
