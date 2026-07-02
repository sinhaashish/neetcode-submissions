class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand)
            count.put(card, count.getOrDefault(card, 0) + 1);
        Arrays.sort(hand);
        for (int card : hand) {
            if (count.get(card) == 0)
                continue;
            for (int i = 0; i < groupSize; i++) {
                int current = card + i;
                if (count.getOrDefault(current, 0) == 0)
                    return false;
                count.put(current, count.get(current) - 1);
            }
        }
        return true;
    }
}