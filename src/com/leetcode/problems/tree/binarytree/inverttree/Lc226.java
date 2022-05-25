package com.leetcode.problems.tree.binarytree.inverttree;

import java.util.LinkedList;
import java.util.Queue;

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
    //方法一：递归
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

    //方法二：层次遍历
    public TreeNode invertTree2(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}