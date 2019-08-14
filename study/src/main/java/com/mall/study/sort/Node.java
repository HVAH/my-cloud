package com.mall.study.sort;

/**
 * 单向链表
 */
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }


    public static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }


    public static Node reverseList(Node node) {
        Node pre = null;
        Node next = null;
        int i = 0;
        while (node != null) {
            i++;
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        System.out.println(i);
        return pre;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = node.next = new Node(2);
        Node node2 = node1.next = new Node(3);
        node2.next = new Node(4);

        Node node3 = reverseList(node);
        System.out.println("");
    }
}