class CountSquares {

    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yMap = points.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        if (!points.containsKey(x))
            return 0;

        int ans = 0;

        Map<Integer, Integer> sameX = points.get(x);

        for (int ny : sameX.keySet()) {

            if (ny == y)
                continue;

            int side = ny - y;
            int verticalFreq = sameX.get(ny);

            // Right square
            ans += verticalFreq *
                   getCount(x + side, y) *
                   getCount(x + side, ny);

            // Left square
            ans += verticalFreq *
                   getCount(x - side, y) *
                   getCount(x - side, ny);
        }

        return ans;
    }

    private int getCount(int x, int y) {

        if (!points.containsKey(x))
            return 0;

        return points.get(x).getOrDefault(y, 0);
    }
}