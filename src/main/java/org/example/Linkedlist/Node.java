package org.example.Linkedlist;

public class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node(){
        this.data = 0;
        this.next = new Node();
    }

    public Node(int data, Node node){
        this.data = data;
        this.next = node;
    }

    public static void printList(Node head){
        Node pres = head;
        while (pres != null){
            System.out.println(pres.data);
            pres = pres.next;
        }
    }
}
