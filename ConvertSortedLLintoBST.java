public class ConvertSortedLLintoBST {

    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static BinaryTreeNode helper(LinkedListNode low, LinkedListNode high) {

        // if only one node is left then return null
        if (low == high)
            return null;

        LinkedListNode hare = low;
        LinkedListNode tort = low;

        // finding the mid using hare and tortoise method
        while (hare.next != high && hare != high) {
            hare = hare.next;
            if (hare != high && hare.next != high) {
                hare = hare.next;
            }
            tort = tort.next;
        }

        BinaryTreeNode root = new BinaryTreeNode(tort.value);

        root.left = helper(low, tort);
        root.right = helper(tort.next, high);

        return root;
    }

    static BinaryTreeNode sorted_list_to_bst(LinkedListNode head) {
        return helper(head, null);
    }

}
