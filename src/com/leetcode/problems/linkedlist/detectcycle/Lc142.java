package com.leetcode.problems.linkedlist.detectcycle;

import java.util.HashSet;

public class Lc142 {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    //方法二：使用hash表记录已遍历的节点。如果遍历过程中出现了hash表中已存在的节点，即出现了环
    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (null != head) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}