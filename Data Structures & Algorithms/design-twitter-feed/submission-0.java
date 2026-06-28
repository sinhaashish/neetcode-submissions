class Twitter {

    private static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetMap;
    private int timestamp;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId, timestamp++);

        tweet.next = tweetMap.get(userId);

        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // user's own tweets
        if (tweetMap.containsKey(userId))
            pq.offer(tweetMap.get(userId));

        // followed users
        for (int followee :
                followMap.getOrDefault(userId, new HashSet<>())) {

            if (tweetMap.containsKey(followee))
                pq.offer(tweetMap.get(followee));
        }

        while (!pq.isEmpty() && result.size() < 10) {

            Tweet tweet = pq.poll();

            result.add(tweet.id);

            if (tweet.next != null)
                pq.offer(tweet.next);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!followMap.containsKey(followerId))
            return;

        followMap.get(followerId).remove(followeeId);
    }
}