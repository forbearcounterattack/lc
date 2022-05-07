package com.leetcode.problems.linkedlist.removenthfromend;

public class Lc19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        int n = 2;

        ListNode resultNode = solution.removeNthFromEnd(head, n);
        while (resultNode != null) {
            System.out.println(resultNode.val + "   ");
            resultNode = resultNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    //方法二：快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = newHead;
        while (n > 0) {
            n--;
            fast = fast.next;
        }
        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }

    //方法一：暴力破解
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode newHead = new ListNode(-1, head);
        ListNode firstTime = newHead;
        int count = 0;
        while (null != firstTime.next) {
            count++;
            firstTime = firstTime.next;
        }
        int times = count - n;
        ListNode secondTime = newHead;
        while (times > 0) {
            secondTime = secondTime.next;
            times--;
        }
        secondTime.next = secondTime.next.next;
        return newHead.next;
    }
}