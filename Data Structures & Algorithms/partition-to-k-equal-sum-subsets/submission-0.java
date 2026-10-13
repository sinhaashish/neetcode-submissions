class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {  total += num;  }
        // Total sum must be divisible by k
        if (total % k != 0) { return false;}
        int target = total / k;
        Arrays.sort(nums);
        // Largest number cannot exceed target
        if (nums[nums.length - 1] > target) { return false; }
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, nums.length - 1, k, 0, target);
    }
    private boolean backtrack(int[] nums, boolean[] used, int index, int k,
                              int currentSum, int target) {

        if (k == 1) {
            return true; // All but one subset have been formed
        }
        // Current subset is complete
        if (currentSum == target) {
            return backtrack(nums, used, nums.length - 1, k - 1, 0, target);
        }
        // Try numbers from largest to smallest
        for (int i = index; i >= 0; i--) {
            if (used[i]) { continue; }
            if (currentSum + nums[i] > target) { continue; }
            // Choose this number
            used[i] = true;
            if (backtrack(nums, used, i - 1, k, currentSum + nums[i], target)) {
                return true;
            }
            // Undo the choice
            used[i] = false;
            // Avoid trying equivalent empty subsets
            if (currentSum == 0) {
                return false;
            }
        }
        return false;
    }
}
