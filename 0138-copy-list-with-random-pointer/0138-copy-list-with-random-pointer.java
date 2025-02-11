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
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node original = head;
        while (original != null) {
            map.put(original,new Node(original.val));
            original = original.next;
        }
        original = head;
        while (original != null){
            Node copiedNode = map.get(original);
            copiedNode.next = map.get(original.next);
            copiedNode.random = map.get(original.random);
            original = original.next;
        }
        
        return map.get(head);
    }
}