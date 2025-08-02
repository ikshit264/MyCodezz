class Solution {
    // 1->2->3->4->5->6->7->8->null   k=3

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0), curr=dummy;
        dummy.next=head;
        
        while(curr!=null) {
            // start and end are exclusive
            ListNode start=curr;
            
            // get Kth node
            ListNode kthNode=getKthNode(curr, k);
            if(kthNode==null)   break;
            ListNode end=kthNode.next;
            
            // reverse logic
            kthNode.next=null;
            ListNode reversedHead=reverse(start.next);
            ListNode reversedTail=start.next;
            
            // link nodes
            start.next=reversedHead;
            reversedTail.next=end;
            curr=reversedTail;
            
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode curr, int k) {
        int count=0;
        while(curr!=null && count<k) {
            count++;
            curr=curr.next;
        }
        return curr;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev=null, curr=head, next;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
}