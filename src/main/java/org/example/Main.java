package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public static void main(String[] args) {


        ListNode la3 = new ListNode(3);
        ListNode la2 = new ListNode(2, la3);
        ListNode la1 = new ListNode(4, la2);

        ListNode lb3 = new ListNode(4);
        ListNode lb2 = new ListNode(6, lb3);
        ListNode lb1 = new ListNode(5, lb2);

        AddTwoNumLL.addTwoNumbers(la1, lb1);
    }
}