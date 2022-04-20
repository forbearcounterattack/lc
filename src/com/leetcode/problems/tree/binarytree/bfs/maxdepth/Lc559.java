package com.leetcode.problems.tree.binarytree.bfs.maxdepth;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc559 {
    public static void main(String[] args) {

    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


class Solution2 {
    //方法一：递归
    public int maxDepth1(Node root) {
        if (null == root) {
            return 0;
        }
        int max = 0;
        for (Node node : root.children) {
            int nodeHeight = maxDepth(node);
            if (nodeHeight > max) {
                max = nodeHeight;
            }
        }
        return max + 1;
    }

    //方法二：层次遍历
    public int maxDepth(Node root) {
        int max = 0;
        Queue<Node> queue = new LinkedList<Node>();
        if (null != root) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    if (null != child) {
                        queue.offer(child);
                    }
                }
            }
            max++;
        }
        return max;
    }
}