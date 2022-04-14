package com.leetcode.problems.tree.binarytree.bfs.levelorderext1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc429 {
    public static void main(String[] args) {

    }
}

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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        Queue<Node> queue = new LinkedList();
        if (null != root) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (null != node) {
                    list.add(node.val);
                }
                if (null != node.children) {
                    for (int j = 0; j < node.children.size(); j++) {
                        if (null != node.children.get(j)) {
                            queue.offer(node.children.get(j));
                        }
                    }
                    //优化
                    //queue.addAll(node.children);
                }
            }
            result.add(list);
        }
        return result;
    }
}
