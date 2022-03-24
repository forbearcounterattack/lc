package com.leetcode.problems.tree.binarytree.inverttree;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc226 {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        exchangeLeftRight(root);
        return root;
    }

    private void exchangeLeftRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            exchangeLeftRight(root.left);
        }
        if (root.right != null) {
            exchangeLeftRight(root.right);
        }
    }
}