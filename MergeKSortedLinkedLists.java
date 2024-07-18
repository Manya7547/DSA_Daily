import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {
        PriorityQueue<LinkedListNode> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null)
                pq.add(lists.get(i));
        }

        LinkedListNode sentinel = new LinkedListNode(Integer.MIN_VALUE);
        LinkedListNode tail = sentinel;

        while (!pq.isEmpty()) {
            LinkedListNode extracted = pq.poll();
            tail.next = extracted;
            tail = extracted;
            if (extracted.next != null) {
                pq.add(extracted.next);
            }
        }
        return sentinel.next;
    }

}
