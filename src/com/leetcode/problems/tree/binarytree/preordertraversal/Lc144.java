package com.leetcode.problems.tree.binarytree.preordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc144 {
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

    //非递归--前序遍历二叉树
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(null != node){
                result.add(node.val);
            }else{
                continue;
            }
            stack.push(node.right);
            stack.push(node.left);
        }
        return result;
    }

    //非递归--前序遍历二叉树
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                list.add(curNode.val);
                stack.add(curNode);
                curNode = curNode.left;
            } else {
                TreeNode popNode = stack.pop();
                curNode = popNode.right;
            }
        }
        return list;
    }


    //递归--前序遍历二叉树
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder1(root, list);
        return list;
    }

    private void preOrder1(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        list.add(root.val);
        preOrder1(root.left, list);
        preOrder1(root.right, list);
    }
}