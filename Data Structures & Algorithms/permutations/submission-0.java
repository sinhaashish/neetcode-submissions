class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack( result , new ArrayList<Integer>(), nums );
        return result; 
    }

    public void backTrack(  List<List<Integer>> result,  List<Integer> tempList, int nums[] ) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        }
        for ( int i = 0 ; i < nums.length; i++) {
           if ( tempList.contains(nums[i])) { continue;}
            tempList.add(nums[i]);
            backTrack(result, tempList, nums);
            tempList.remove(tempList.size() -1);
        }
    }
        
    
}
