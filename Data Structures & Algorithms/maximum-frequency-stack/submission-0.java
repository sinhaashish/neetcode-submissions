class FreqStack {
    // Stores the frequency of each number
    private Map<Integer, Integer> freq;
    // group.get(f) stores values whose frequency reached f
    private Map<Integer, Deque<Integer>> group;
    // Maximum frequency currently present
    private int maxFreq;
    public FreqStack() {
        freq = new HashMap<Integer, Integer>();
        group = new HashMap<Integer, Deque<Integer>>();
        maxFreq = 0;
    }
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (!group.containsKey(f)) {
            group.put(f, new ArrayDeque<Integer>());
        }
        group.get(f).push(val);
        if (f > maxFreq) {
            maxFreq = f;
        }
    }
    public int pop() {
        Deque<Integer> stack = group.get(maxFreq);
        int val = stack.pop();
        freq.put(val, freq.get(val) - 1);
        if (stack.isEmpty()) {
            maxFreq--;
        }
        return val;
    }
}