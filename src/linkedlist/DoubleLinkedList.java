package linkedlist;

public class DoubleLinkedList {
    class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
            next = null;
            prev = null;
        }
    }
    Node head , tail;
    int size ;

    DoubleLinkedList(){
        head = tail = null;
        size = 0;
    }

    void add(int val){
        Node newNode = new Node(val);

        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void deleteNode(Node del){
        if(head == null || del == null){
            return ;
        }
        if(head == del){
            head = head.next;
        }
        if(del.next!=null){
            del.next.prev = del.prev;
        }
        if(del.prev!=null){
            del.prev.next = del.next;
        }
    }

    void reverse(){
        Node temp = null;
        Node cur = head;
        while (cur!=null){
            temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp;
            cur = cur.prev;
        }
        if(temp !=null){
            head = temp.prev;
        }
    }

    @Override
    public String toString() {
        String res = "";
        Node temp = head;
        while (temp != null) {
            res += temp.val + " ";
            temp = temp.next;
        }
        return res;
    }

}
