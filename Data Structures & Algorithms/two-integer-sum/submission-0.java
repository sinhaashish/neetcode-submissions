class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                // ✅ use nums[i] as the key (not target - nums[i])
                return new int[] { hashMap.get(nums[i]), i };
            } else {
                hashMap.put(target - nums[i], i);
                System.out.println("After inserting " + nums[i] + ": " + hashMap);
            }
        }
        return new int[]{};
    }
}