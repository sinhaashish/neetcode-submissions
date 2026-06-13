class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for ( int i =0; i <= n ; i++) {
            arr[i] = countNuberOfOne(i);
        }
        return arr;
    }
    public int countNuberOfOne( int n) {
        int count = 0 ;
        while ( n > 0 ) {
            if ( (n &1 ) == 1 ) {
                count++;
            }
            n = n >>1 ;
        }
        return count;
    }
}
