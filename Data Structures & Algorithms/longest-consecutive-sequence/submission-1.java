class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for( int num: nums) {
            s.add(num);
        }
        int longest = 0;

        for (int num : s) {
            if (!s.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (s.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
