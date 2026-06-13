class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        rightMax[size - 1] = height[size - 1];
        for ( int i = 1;  i <size; i ++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for ( int j = size -2 ; j >=0 ; j--) {
            rightMax[j] = Math.max(rightMax[j+1],height[j]);
        }
        int water =0;
        for ( int i =0 ; i < size ; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
