package com.leetcode.problems.tree.binarytree.inordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc94 {
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

    //非递归--中序遍历二叉树
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //创建一个指向当前节点的指针，初始化的时候指向根节点
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.add(curNode);
                curNode = curNode.left;
            } else {
                TreeNode popNode = stack.pop();
                list.add(popNode.val);
                curNode = popNode.right;
            }
        }
        return list;
    }


    //递归--中序遍历二叉树
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        infixOrder1(root, list);
        return list;
    }

    private void infixOrder1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        infixOrder1(root.left, list);
        list.add(root.val);
        infixOrder1(root.right, list);
    }
}