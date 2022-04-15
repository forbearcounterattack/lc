package com.leetcode.problems.tree.binarytree.bfs.maxdepth;

import java.util.LinkedList;
import java.util.Queue;

public class Lc104 {
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
    public int maxDepth(TreeNode root) {
        int max = 0;
        Queue<TreeNode> queue = new LinkedList();
        if (null != root) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            max += 1;
        }
        return max;
    }
}