public class LinkedNode<E> {

    public E data;
    LinkedNode<E> next;

    public LinkedNode( E data , LinkedNode<E> next){
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {

        LinkedNode<String> thirdNode = new LinkedNode<String>("third", null);
        LinkedNode<String> secondNode = new LinkedNode<String>("second", thirdNode);
        LinkedNode<String> firstNode = new LinkedNode<String>("first", secondNode);

        // LinkedNode<String> node = firstNode;
        // while (node != null) {
        //     System.out.println(node.data);
        //     node = node.next;
        // }

        for (LinkedNode<String> node = firstNode; node != null; node = node.next) {
            System.out.println(node.data);
        }

    }
    
}
