class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Duplicate exists within distance k
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // Keep only the previous k elements
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}