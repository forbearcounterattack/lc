package com.leetcode.problems.queue.recentcounter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc933 {
    public static void main(String[] args) {
    }
}

class RecentCounter {

    public Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty()) {
            if (queue.peek() < t-3000) {
                queue.poll();
            } else {
                break;
            }
        }
        return queue.size();
    }

    public int ping2(int t) {
        queue.add(t);
        while (queue.peek() < t-3000) {
            queue.poll();
        }
        return queue.size();
    }
}
