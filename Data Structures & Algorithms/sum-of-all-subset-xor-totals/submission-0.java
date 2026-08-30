class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack( result , new ArrayList<Integer>(), nums , 0 );
        int sum =0; 
        for ( List<Integer> l : result) {
            int xor = 0;
            for ( Integer a : l) {
                xor = xor ^ a;
            }
            sum += xor;
        }
        return sum;
        
    }

    public void backTrack(  List<List<Integer>> result,List<Integer> tempList, int nums[], 
         int start ) {
        result.add(new ArrayList<>(tempList));
        for ( int i = start ; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(result, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }
}