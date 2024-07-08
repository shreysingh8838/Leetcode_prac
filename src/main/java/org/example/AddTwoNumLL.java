package org.example;


public class AddTwoNumLL {
    public static ListNode  addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        int i = 0;
        int j = 0;

        ListNode resHead = null;
        int carry = 0;
        int total = 0;
        while(cur1 != null || cur2 != null){
            if(cur1 != null){
                i = cur1.val;
            }

            if(cur2 != null){
                j = cur2.val;
            }


            total = i + j + carry;

            if(total > 9 )
                carry = 1;
            else carry = 0;

            ListNode newNode = new ListNode(total%10);
            if(resHead == null){
                resHead = newNode;
            } else {
                ListNode temp = resHead;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        return resHead;

    }
}
