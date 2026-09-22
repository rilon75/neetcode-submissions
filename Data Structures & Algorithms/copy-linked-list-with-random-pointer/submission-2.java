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
        Node copy = new Node(0);
        Node traverse = head;
        while (traverse != null) {
            Node cur = new Node(traverse.val);
            hm.put(traverse, cur);
            traverse = traverse.next;
        }
        traverse = head;
        Node cTraverse = copy;
        while (traverse != null) {
            Node cur = hm.get(traverse);
            Node random = hm.get(traverse.random);
            Node next = hm.get(traverse.next);
            traverse = traverse.next;
            cTraverse.next = cur;
            cTraverse = cTraverse.next;
            cTraverse.next = next;
            cTraverse.random = random;
        }
        return copy.next;
    }
}
