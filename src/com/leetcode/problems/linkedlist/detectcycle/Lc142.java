package com.leetcode.problems.linkedlist.detectcycle;

import java.util.HashSet;
import java.util.Set;

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
    //方法二：快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast) {
            if (null != fast.next) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                ListNode cur = head;
                //从第一次相遇起，慢指针每次挪一步，cur指针从head开始每次也挪动一步，当它们相遇时，相遇点在环口
                while (cur != slow) {
                    slow = slow.next;
                    cur = cur.next;
                }
                return slow;
            }
        }
        return null;
    }

    //方法一：使用hash表
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode cur = head;
        while (null != cur) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
}