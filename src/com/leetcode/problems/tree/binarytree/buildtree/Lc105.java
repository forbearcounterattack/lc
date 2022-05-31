package com.leetcode.problems.tree.binarytree.buildtree;

public class Lc105 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return Helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode Helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        root.left = Helper(preorder, preLeft + 1, rootIndex - inLeft + preLeft, inorder, inLeft, rootIndex - 1);
        root.right = Helper(preorder, rootIndex - inLeft + preLeft + 1, preRight, inorder, rootIndex + 1, inRight);
        return root;
    }
}
