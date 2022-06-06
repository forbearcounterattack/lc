package com.leetcode.problems.tree.binarytree.haspathsum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lc112 {
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
    //方法二：BFS
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        Queue<TreeNode> qNode = new LinkedList();
        Queue<Integer> qSum = new LinkedList();
        qNode.offer(root);
        qSum.offer(root.val);
        while (!qNode.isEmpty()) {
            int size = qNode.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = qNode.poll();
                int sum = qSum.poll();
                if (null == node.left && null == node.right) {
                    if (sum == targetSum) {
                        return true;
                    }
                }
                if (null != node.left) {
                    qNode.offer(node.left);
                    qSum.offer(sum + node.left.val);
                }
                if (null != node.right) {
                    qNode.offer(node.right);
                    qSum.offer(sum + node.right.val);
                }
            }
        }
        return false;
    }


    //方法一：DFS
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        Stack<TreeNode> stackNode = new Stack();
        stackNode.push(root);
        Stack<Integer> stackSum = new Stack();
        stackSum.push(root.val);
        while (!stackNode.isEmpty()) {
            TreeNode node = stackNode.pop();
            int sum = stackSum.pop();
            if (null == node.left && null == node.right) {
                if (targetSum == sum) {
                    return true;
                }
            }
            if (null != node.right) {
                stackNode.push(node.right);
                stackSum.push(sum + node.right.val);
            }
            if (null != node.left) {
                stackNode.push(node.left);
                stackSum.push(sum + node.left.val);
            }
        }
        return false;
    }
}