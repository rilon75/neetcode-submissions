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
        if (head == null) {
             return null;
        }
        Map<Node, Node> hm = new HashMap<>();
        Node traverse = head;
        while (traverse != null) {
            hm.put(traverse, new Node(traverse.val));
            traverse = traverse.next;
        }
        traverse = head;
        while (traverse != null) {
            Node cur = hm.get(traverse);
            cur.random = hm.get(traverse.random);
            cur.next = hm.get(traverse.next);
            traverse = traverse.next;
        }
        return hm.get(head);
    }
}
