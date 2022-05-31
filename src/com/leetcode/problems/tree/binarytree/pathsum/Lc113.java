package com.leetcode.problems.tree.binarytree.pathsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc113 {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stackNode = new Stack();
        stackNode.push(root);
        List<Integer> temp = new ArrayList();
        temp.add(root.val);
        Stack<List<Integer>> stackSum = new Stack();
        stackSum.push(temp);
        while (!stackNode.isEmpty()) {
            TreeNode node = stackNode.pop();
            List<Integer> list = stackSum.pop();
            if (null == node.left && null == node.right) {
                int sum = 0;
                for (int a : list) {
                    sum += a;
                }
                if (targetSum == sum) {
                    result.add(new ArrayList<>(list));
                }
            }
            if (null != node.right) {
                stackNode.push(node.right);
                List<Integer> newList = new ArrayList();
                for (int a : list) {
                    newList.add(a);
                }
                newList.add(node.right.val);
                stackSum.push(new ArrayList<>(newList));
            }
            if (null != node.left) {
                stackNode.push(node.left);
                List<Integer> newList = new ArrayList();
                for (int a : list) {
                    newList.add(a);
                }
                newList.add(node.left.val);
                stackSum.push(new ArrayList<>(newList));
            }
        }
        return result;
    }

    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stackNode = new Stack();
        stackNode.push(root);
        Stack<String> stackSum = new Stack();
        stackSum.push("" + root.val);
        while (!stackNode.isEmpty()) {
            TreeNode node = stackNode.pop();
            String str = stackSum.pop();
            if (null == node.left && null == node.right) {
                int sum = 0;
                String[] split = str.split(",");
                List<Integer> tempList = new ArrayList();
                for (String a : split) {
                    sum += Integer.valueOf(a);
                    tempList.add(Integer.valueOf(a));
                }
                if (targetSum == sum) {
                    result.add(new ArrayList<>(tempList));
                }
            }
            if (null != node.right) {
                stackNode.push(node.right);
                stackSum.push(str + "," + node.right.val);
            }
            if (null != node.left) {
                stackNode.push(node.left);
                stackSum.push(str + "," + node.left.val);
            }
        }
        return result;
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stackNode = new Stack();
        stackNode.push(root);
        List<Integer> temp = new ArrayList();
        temp.add(root.val);
        Stack<List<Integer>> stackSum = new Stack();
        stackSum.push(temp);
        while (!stackNode.isEmpty()) {
            TreeNode node = stackNode.pop();
            List<Integer> list = stackSum.pop();
            if (null == node.left && null == node.right) {
                int sum = 0;
                for (int a : list) {
                    sum += a;
                    System.out.println(a);
                }
                System.out.println("sdddddddddddd");
                if (targetSum == sum) {
                    result.add(new ArrayList<>(list));
                }
            }
            if (null != node.right) {
                stackNode.push(node.right);
                list.add(node.right.val);
                stackSum.push(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            if (null != node.left) {
                stackNode.push(node.left);
                list.add(node.left.val);
                stackSum.push(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }
        return result;
    }
}
