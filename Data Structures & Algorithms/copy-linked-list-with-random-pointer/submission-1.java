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
        Map<Node, Integer> hm = new HashMap<>();
        List<Node> order = new ArrayList<>();
        int index = 0;
        Node copy = new Node(0);
        Node cTraverse = copy;
        Node traverse = head;
        while (traverse != null) {
            hm.put(traverse, index);
            Node cur = new Node(traverse.val);
            traverse = traverse.next;
            cTraverse.next = cur;
            order.add(cur);
            cTraverse = cTraverse.next;
            index++;
        }
        traverse = head;
        cTraverse = copy.next;
        while (traverse != null) {
            Node random = traverse.random;
            if (random != null) {
                int i = hm.get(random);
                cTraverse.random = order.get(i);
            }
            traverse = traverse.next;
            cTraverse = cTraverse.next;
        }
        return copy.next;
    }
}
