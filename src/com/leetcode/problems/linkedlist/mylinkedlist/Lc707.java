package com.leetcode.problems.linkedlist.mylinkedlist;

public class Lc707 {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(1);
        obj.addAtHead(22);
        obj.addAtTail(33);
        obj.addAtIndex(1, 44);
        obj.addAtIndex(2, 55);
        obj.addAtIndex(2, 77);
        obj.addAtIndex(2, 88);
        obj.addAtIndex(2, 99);
        obj.deleteAtIndex(2);

        while (obj.head != null) {
            System.out.println(obj.head.val);
            obj.head = obj.head.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode nextNode) {
        this.val = val;
        this.next = nextNode;
    }
}

class MyLinkedList {
    int size = 0;
    ListNode head;

    public MyLinkedList() {
        head = new ListNode(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        int count = 0;
        while (null != cur && count <= index) {
            count++;
            cur = cur.next;
        }
        return cur.val;
    }

    //在链表最前面插入一个节点
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (head.next == null) {
            head.next = node;
        } else {
            ListNode cur = head;
            while (null != cur.next) {
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode cur = head;
        int count = 0;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        int count = 0;
        while (count < index) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        pre.next = cur.next;
        size--;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */