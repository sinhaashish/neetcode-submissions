class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        // Every child gets at least one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        // Left to right:
        // If rating is higher than the left neighbor,
        // give one more candy than the left neighbor.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Right to left:
        // If rating is higher than the right neighbor,
        // ensure this child gets more candies.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(
                    candies[i],
                    candies[i + 1] + 1
                );
            }
        }
        // Calculate the total
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += candies[i];
        }
        return total;
    }
}