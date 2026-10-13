
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) { return false; }
        int total = 0;
        for (int stick : matchsticks) { total += stick;}
        if (total % 4 != 0) { return false; }// Total length must be divisible by 4  }
        int target = total / 4;  Arrays.sort(matchsticks);
        // Largest stick cannot exceed the side length
        if (matchsticks[matchsticks.length - 1] > target) { return false; }
        int[] sides = new int[4];
        for (int i = 0, j = matchsticks.length - 1;  i < matchsticks.length / 2; i++, j--) { 
            int temp = matchsticks[i];   // Place larger sticks first
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return backtrack(matchsticks, sides, 0, target);
    }
    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        // All matchsticks have been placed
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target  && sides[3] == target;
        }
        int stick = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            // Do not exceed the target side length
            if (sides[i] + stick > target) { continue; }
            sides[i] += stick;
            if (backtrack(matchsticks, sides, index + 1, target)) { return true; }
            // Undo the choice
            sides[i] -= stick;
            // All currently empty sides are equivalent
            if (sides[i] == 0) {  break; }
        }
        return false;
    }
}
