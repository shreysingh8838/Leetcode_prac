package org.example.Linkedlist;

public class MergeLinkedList {

    public static Node mergeLinkedlist(Node head1, Node head2){
        Node curr = head1;
        Node last1 = new Node();
        while (curr != null){
            if(curr.next == null) {
                last1 = curr;
                break;
            }
            System.out.println(curr.data);
            curr = curr.next;
        }
        last1.next = head2;
        return head1;
    }

    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1,n2);

        Node n8 = new Node(8);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5,n6);

        Node head = MergeLinkedList.mergeLinkedlist(n1, n5);
        Node.printList(head);
    }
}
