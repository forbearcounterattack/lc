package com.leetcode.problems.tree.binarytree.countnodes;

public class Lc222 {
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

    public int countNodes1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);
        return left + right + 1;
    }


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left); // 求左树高
        int right = getHeight(root.right); // 求右树高
        if (left == right) {
            //return (1 << l) + countNodes(root.right);
            // 左必满 Math.pow(2, l) - 1 + 右树高 + 1
            return (int) Math.pow(2, left) - 1 + countNodes(root.right) + 1;
        } else {
            //return (1 << r) + countNodes(root.left);
            // 右必满 Math.pow(2, r) - 1 + 左树高 + 1
            return (int) Math.pow(2, right) - 1 + countNodes(root.left) + 1;
        }
    }

    // 求树高
    public int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            // 因为完全二叉树最后非空的一定是左子树
            root = root.left;
            height++;
        }
        return height;
    }
}
