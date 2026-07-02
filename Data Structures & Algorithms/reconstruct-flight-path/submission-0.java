class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Build graph
        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        dfs("JFK");

        return itinerary;
    }

    private void dfs(String airport) {

        PriorityQueue<String> pq = graph.get(airport);

        while (pq != null && !pq.isEmpty()) {

            String next = pq.poll();

            dfs(next);
        }

        // Add after using all outgoing tickets
        itinerary.addFirst(airport);
    }
}