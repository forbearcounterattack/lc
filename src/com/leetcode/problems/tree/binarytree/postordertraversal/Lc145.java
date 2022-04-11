package com.leetcode.problems.tree.binarytree.postordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc145 {
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
    //方式二：迭代
    public List<Integer> postorderTraversal(TreeNode root) {
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
            stack.add(node.left);
            stack.add(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    //非递归--后序遍历二叉树
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }


    //递归--后序遍历二叉树
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList();
        postOrder1(root, list);
        return list;
    }

    private void postOrder1(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        postOrder1(root.left, list);
        postOrder1(root.right, list);
        list.add(root.val);
    }
}
