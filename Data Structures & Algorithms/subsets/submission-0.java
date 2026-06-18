class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack( result , new ArrayList<Integer>(), nums , 0 );
        return result; 
    }

    public void backTrack(  List<List<Integer>> result,  List<Integer> tempList, int nums[], int start ) {
        result.add(new ArrayList<>(tempList));
        for ( int i = start ; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(result, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }
}
