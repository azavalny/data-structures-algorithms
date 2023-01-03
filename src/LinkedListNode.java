public class LinkedListNode {

    // access the linked list through reference to the head node
    public Object data;
    public LinkedListNode next;
    public LinkedListNode(Object data){
        this.data = data;
    }

    public LinkedListNode prependNode(LinkedListNode head, LinkedListNode toAdd){
        toAdd.next = head;
        return toAdd;
    }

    public LinkedListNode deleteNode(LinkedListNode head, Object toDelete){
        if(head == null) {return null;}
        LinkedListNode current = head;
        if(current.data.equals(toDelete)){
            return head.next;
        }
        while(current.next != null){
         if(current.next.data.equals(toDelete)){
             current.next = current.next.next;
             return head;
         }
         current = current.next;
        }
        return head;
    }

}
