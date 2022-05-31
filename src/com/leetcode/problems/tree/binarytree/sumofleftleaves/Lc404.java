package com.leetcode.problems.tree.binarytree.sumofleftleaves;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lc404 {
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
    //方法二：DFS
    public int sumOfLeftLeaves(TreeNode root) {
        int count = 0;
        if (null == root || (null == root.left && null == root.right)) {
            return count;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node.left) {
                if (null == node.left.left && null == node.left.right) {
                    count += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
        return count;
    }

    //方法一：BFS
    public int sumOfLeftLeaves1(TreeNode root) {
        int count = 0;
        if (null == root || (null == root.left && null == root.right)) {
            return count;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    if (null == node.left.left && null == node.left.right) {
                        count += node.left.val;
                    }
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }
}