class Solution{
    public int  maxArea(int [] height){
        int left = 0; 
        int right = height.length-1; 
        int max = 0;
        while  ( left < right) {
            int width = right -left; 
            int hei = Math.min( height[left], height[right]);
            int current = width * hei;
            max = Math.max(max, current);
            if ( height [left] < height[right]  ) {
                left++;
            } else {
                right --;
            } 
        }
        return max;
    }
}