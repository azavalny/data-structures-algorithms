public class Node {
    private Object data;
    private Node[] children;

    public Node(Object data, Node[] children){
        this.data = data;
        this.children = children;
    }

    // visits nodes in ascending order. Rearrange the order to get preorder and post order traversal
    // left node, current node, right node
    public void BSTinOrderTraversal(Node node){
        if (node != null){
            BSTinOrderTraversal(node.children[0]); // left child
            System.out.println(node.data);
            BSTinOrderTraversal(node.children[1]); // right child
        }
    }

}
