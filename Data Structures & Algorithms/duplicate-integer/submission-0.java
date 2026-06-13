class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for ( int num : nums) {
            if (!hs.add(num)){
                return true;
            }
        }
        return false;
        
    }
}