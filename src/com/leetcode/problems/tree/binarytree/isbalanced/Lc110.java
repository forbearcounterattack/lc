package com.leetcode.problems.tree.binarytree.isbalanced;

public class Lc110 {
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
    public boolean isBalanced(TreeNode root) {
        if (-1 == getHeight(root)) {
            return false;
        }
        return true;
    }


    private int getHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = getHeight(root.left);
        if (-1 == left) {
            return -1;
        }
        int right = getHeight(root.right);
        if (-1 == right) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}