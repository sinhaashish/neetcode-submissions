class Solution {
    public int missingNumber(int[] nums) {
        int x =0 ; int i =0;
        for ( i =0 ;i < nums.length; i++) {
            x = x ^ i ^ nums[i];
        }
        return x ^i;
    }
}
