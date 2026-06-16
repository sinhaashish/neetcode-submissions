class Solution {
    public int search(int[] nums, int target) {
        return binary_search( nums,  0 , nums.length -1, target  );
        
    }

    public int binary_search( int [] nums, int i , int j , int target  ) {
         if ( i > j ) {
             return -1;
         }
         int mid =  i + (j -i )/2;
         if (nums[mid] == target) return mid;
         return (nums[mid]< target) ? binary_search( nums , mid +1, j , target ) : binary_search( nums , i, mid-1 , target );
    }
}
