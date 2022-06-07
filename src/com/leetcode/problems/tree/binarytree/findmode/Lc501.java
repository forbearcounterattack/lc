package com.leetcode.problems.tree.binarytree.findmode;

import java.util.*;

public class Lc501 {
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
    public int[] findMode(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        List<Integer> list = new ArrayList();
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (null == map.get(cur.val)) {
                    map.put(cur.val, 1);
                } else {
                    map.put(cur.val, 1 + map.get(cur.val));
                }
                cur = cur.right;
            }
        }
        int curMax = -1;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (list.size() == 0) {
                curMax = value;
                list.add(key);
            } else {
                if (value == curMax) {
                    list.add(key);
                } else if (value > curMax) {
                    curMax = value;
                    list.clear();
                    list.add(key);
                } else {
                    continue;
                }
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int temp : list) {
            result[index++] = temp;
        }
        return result;
    }
}