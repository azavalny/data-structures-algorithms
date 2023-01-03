public class ChapterTwo{

    public void deleteDuplicates(LinkedListNode head){
        //use hash table to add all elements and see if there's a duplicate
        // "remove" (unlink) node by setting the previous node's next to the current node's next
        HashSet <Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while(head != null){
            if(set.contains(head.data)){
                previous.next = head.next;
            } else{
                set.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    public int returnKToLast(LinkedListNode head, int k){
        if(head == null){
            return 0;
        }
        int index = printKToLast(head.next, k) + 1;
        if(index == k){
            return head.data;
        }
        return index;
    }

}