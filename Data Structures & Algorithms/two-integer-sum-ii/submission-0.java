class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for ( int i =0 ; i < numbers.length; i++) {
            if ( hs.containsKey(target-numbers[i])) {
                result[1] = i+1;
                result[0] = hs.get(target-numbers[i])+1;
            }
            hs.put(numbers[i], i);
        }
        return result;
        
    }
}
