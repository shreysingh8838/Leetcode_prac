package org.example.Linkedlist;

import java.util.LinkedList;

public class ReverseLinkedlist {
    Node node;


    public static Node reverseList(Node head){
        Node pres = head.next;
        Node prev = head;
        prev.next = null;
        while(pres != null) {
            Node temp = pres.next;
            pres.next = prev;
            prev = pres;
            pres = temp;
        }
        return prev;
    }


    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1,n2);

        Node head = ReverseLinkedlist.reverseList(n1);
        Node.printList(head);
    }
}
