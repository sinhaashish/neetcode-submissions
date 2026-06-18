class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>> result = new ArrayList();
       backTrack(nums , result, new ArrayList(), target, 0 );
       return result; 
    }

    public void backTrack(int nums[], List<List<Integer>> result, 
                    List <Integer> tempList, int remain, int start ) {
        
        if ( remain < 0) { return;}
        else if (remain == 0 ) {
            result.add( new ArrayList<>(tempList));
        }
        else {
            for ( int i = start ; i < nums.length; i++) {
                tempList.add(nums[i]);
                backTrack(nums, result, tempList, remain - nums[i], i);
                tempList.remove(tempList.size() -1);
            }
        }

    }
}
