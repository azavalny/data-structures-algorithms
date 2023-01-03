class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

    def prependNode(self, head, toAdd)
        toAdd.next = head

    def removeNode(self, head, toRemove)
        if head == None:
            return None

        current = head
        while current.next != null:
            if current.data == toRemove:
                current.next = current.next.next
                return head
            current = current.next

        return head
        
