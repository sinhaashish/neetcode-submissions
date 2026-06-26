class Solution {

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node curr = head;

        // Pass 1: Insert copied nodes
        while (curr != null) {

            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        // Pass 2: Set random pointers
        curr = head;

        while (curr != null) {

            if (curr.random != null)
                curr.next.random = curr.random.next;

            curr = curr.next.next;
        }

        // Pass 3: Separate the lists
        curr = head;

        Node dummy = new Node(0);
        Node copyTail = dummy;

        while (curr != null) {

            Node copy = curr.next;

            curr.next = copy.next;     // Restore original list

            copyTail.next = copy;      // Build copied list
            copyTail = copy;

            curr = curr.next;
        }

        return dummy.next;
    }
}