package objetos.parcial3.examen;

public class TravelAgency {

    private Node<UserAccount> head;
    private Node<UserAccount> tail;
    private int size;


    private static class Node<H> extends UserAccount {
        Node<H> next;
        Node<H> previous;
        H data;

        public Node(H data) {
            this.data = data;
        }

    }

    
    
    public String addUserAccount(UserAccount userAccount1) {
        Node<UserAccount> node = new Node<>(userAccount1);
        node.next= head;
        head = node;

        if( tail == null) {
            tail = node;
        }else{
            node.next.previous = node;
        }
        size++;
    }

    public UserAccount findAccount(String id1) {
        Node<UserAccount> iteratorNode = head;
        int indexIteratorNode = 0;

        while (indexIteratorNode < id1){
            iteratorNode = iteratorNode.next;
            indexIteratorNode++;
        }
        return iteratorNode;
    }

    public UserAccount findAccountByEmail(String s) {
        Node<UserAccount> iteratorNode = head;
        int indexIteratorNode = ;

        int index = 0;
        while (indexIteratorNode != s){
            iteratorNode = iteratorNode.next;
            indexIteratorNode++;
        }
        return iteratorNode;
    }

    public UserAccount findAccountByPhoneNumber(String s) {
    }
}
