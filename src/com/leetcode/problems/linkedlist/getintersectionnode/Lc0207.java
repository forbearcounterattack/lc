package com.leetcode.problems.linkedlist.getintersectionnode;

public class Lc0207 {
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getLength(headA);
        int b = getLength(headB);
        int l = Math.abs(a - b);
        if (0 != l) {
            if (a > b) {
                while (l > 0) {
                    l--;
                    headA = headA.next;
                }
            } else {
                while (l > 0) {
                    l--;
                    headB = headB.next;
                }
            }
        }
        ListNode a1 = headA;
        ListNode b1 = headB;
        while (null != a1) {
            if (a1 == b1) {
                return a1;
            }
            a1 = a1.next;
            b1 = b1.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int a = getLength(headA);
        int b = getLength(headB);
        if (a == b) {
            ListNode a1 = headA;
            ListNode b1 = headB;
            while (null != a1) {
                if (a1 == b1) {
                    return a1;
                }
                a1 = a1.next;
                b1 = b1.next;
            }
            return null;
        } else if (a > b) {
            int l = a - b;
            while (l > 0) {
                l--;
                headA = headA.next;
            }
            ListNode a1 = headA;
            ListNode b1 = headB;
            while (null != a1) {
                if (a1 == b1) {
                    return a1;
                }
                a1 = a1.next;
                b1 = b1.next;
            }
            return null;
        } else if (a < b) {
            int l = b - a;
            while (l > 0) {
                l--;
                headB = headB.next;
            }
            ListNode a1 = headA;
            ListNode b1 = headB;
            while (null != a1) {
                if (a1 == b1) {
                    return a1;
                }
                a1 = a1.next;
                b1 = b1.next;
            }
            return null;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (null != head) {
            count++;
            head = head.next;
        }
        return count;
    }
}