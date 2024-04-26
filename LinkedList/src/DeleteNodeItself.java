public class DeleteNodeItself {
    public static void main(String[] args) {

    }
    public void deleteNode(basics.Node node){
        node.data=node.next.data;
        node.next=node.next.next;
    }
}
