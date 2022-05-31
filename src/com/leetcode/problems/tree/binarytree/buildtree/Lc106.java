package com.leetcode.problems.tree.binarytree.buildtree;

public class Lc106 {
    public static void main(String[] args) {

    }
}

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return Helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode Helper(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        root.left = Helper(postorder, postLeft, rootIndex - 1 - inLeft + postLeft, inorder, inLeft, rootIndex - 1);
        root.right = Helper(postorder, rootIndex - inLeft + postLeft, postRight - 1, inorder, rootIndex + 1, inRight);
        return root;
    }
}
