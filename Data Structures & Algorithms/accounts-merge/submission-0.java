public class Solution {
    Map<String, Integer> emailIdx = new HashMap<>(); List<String> emails = new ArrayList<>();
    Map<Integer, Integer> emailToAcc = new HashMap<>();  List<List<Integer>> adj; 
    Map<Integer, List<String>> emailGroup = new HashMap<>();private boolean[] visited;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size(); int m = 0;
        for (int accId = 0; accId < n; accId++) {
            List<String> account = accounts.get(accId);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailIdx.containsKey(email)) { emails.add(email); emailIdx.put(email, m);  emailToAcc.put(m, accId); m++; }
            }
        }
        adj = new ArrayList<>();
        for (int i = 0; i < m; i++) { adj.add(new ArrayList<>()); }
        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                int id1 = emailIdx.get(account.get(i)); int id2 = emailIdx.get(account.get(i - 1));
                adj.get(id1).add(id2); adj.get(id2).add(id1);
            }
        }
        visited = new boolean[m]; // Initialize visited array
        for (int i = 0; i < m; i++) { // BFS traversal
            if (!visited[i]) { int accId = emailToAcc.get(i); emailGroup.putIfAbsent(accId, new ArrayList<>()); bfs(i, accId); }
        }
        List<List<String>> res = new ArrayList<>();
        for (int accId : emailGroup.keySet()) {
            List<String> group = emailGroup.get(accId);  Collections.sort(group);
            List<String> merged = new ArrayList<>(); merged.add(accounts.get(accId).get(0)); merged.addAll(group);
            res.add(merged);
        }
        return res;
    }
    private void bfs(int start, int accId) {
        Queue<Integer> queue = new LinkedList<>(); queue.offer(start); visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll(); emailGroup.get(accId).add(emails.get(node));
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}