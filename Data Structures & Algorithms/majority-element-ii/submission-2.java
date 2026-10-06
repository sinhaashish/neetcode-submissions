class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for ( int n : nums ) {
            hs.put(n , hs.getOrDefault(n, 0)+1);
        }
        for ( Map.Entry<Integer, Integer> m :  hs.entrySet()) {
            if ( m.getValue() > nums.length /3) {
                list.add(m.getKey());
            }
        }
        return list;
        
    }
}