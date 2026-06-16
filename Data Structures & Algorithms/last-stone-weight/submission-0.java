class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq  = new PriorityQueue( 
            new Comparator<Integer>() {
                public int compare( Integer a , Integer b) {
                    return b-a;
                }
                
            }
        );
        for ( int stone : stones) {
            pq.add( stone);
        }

        while ( pq.size() > 1) {
            int heavy = pq.poll();
            int secondHeavy = pq.poll();
            if ( heavy != secondHeavy) {
                pq.add(heavy- secondHeavy);
            }
        }
        return pq.size() == 0 ? 0: pq.peek();
    }   

}
