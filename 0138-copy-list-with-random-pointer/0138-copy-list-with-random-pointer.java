/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> store = new HashMap<>();

        Node curr = head;

        store.put(null, null);

        while (curr != null){
            store.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while (curr != null){
            Node copy = store.get(curr);

            copy.random = store.get(curr.random);
            copy.next = store.get(curr.next);
            curr = curr.next;
        }

        return store.get(head);

    }

}