package solution300_399.solution355;

import java.util.*;

/**
 * Script Created by daidai on 2017/7/6.
 */
public class Twitter {

    private static int timestamp = 0;
    private Map<Integer, User> userMap = new HashMap<>();

    private class Tweet {
        private int id;
        private int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
        }
    }

    private class User {
        private int userId;
        private Tweet head;
        private Set<Integer> followed;

        public User(int userId) {
            this.userId = userId;
            followed = new HashSet<>();
            follow(userId);
        }

        private void follow(int userId) {
            followed.add(userId);
        }

        private void unFollow(int userId) {
            followed.remove(userId);
        }

        private void post(Tweet tweet) {
            tweet.next = head;
            head = tweet;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(new Tweet(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<>(users.size(), (a, b) -> b.time - a.time);

        for (Integer user : users) {
            Tweet head = userMap.get(user).head;
            if (head != null) {
                queue.offer(head);
            }
        }

        int n = 0;
        while (!queue.isEmpty() && n < 10) {
            Tweet first = queue.poll();
            res.add(first.id);
            if (first.next != null) {
                queue.offer(first.next);
            }
            n++;
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !userMap.containsKey(followerId)) {
            return;
        }
        userMap.get(followerId).unFollow(followeeId);
    }

    public static void main(String[] args) {
        /*
        ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
        [[],[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],[2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211],[1],[1,2],[1],[1,2],[1]]
        */
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);
        System.out.println(twitter.getNewsFeed(1));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
