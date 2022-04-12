package com.leetcode.problems.tree.binarytree.bfs.rightsideview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc199 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (null != root) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int last = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node) {
                    last = node.val;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            if (Integer.MIN_VALUE != last) {
                result.add(last);
            }
        }
        return result;
    }
}