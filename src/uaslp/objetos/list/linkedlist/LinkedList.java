package uaslp.objetos.list.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    //Agregar a la cola
    public void addAtTail(String data) {
        Node node = new Node(data);

        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }

        tail = node;
        size++;
    }

    //Agregar al en frente
    public void addAtFront(String data) {
        Node node = new Node(data);

        if (size == 0) {
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;

        size++;
    }

    public void remove(int index) {
        Node node = findNode(index);

        //no tiene nada
        if(node == null){
            return;
        }

        if(size == 1){
            head = null;
            tail = null;
        } else if(node == head){
            head = node.next;
            if(head != null){
                head.previous = null;
            }
        } else if(node == tail){
            tail = node.previous;
            if(tail != null){
                tail.next = null;
            }
        } else {//esta en medio
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

    //aqui utilizamos garbage colector
    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public void setAt(int index, String data) {
        Node node = findNode(index);

        if(node != null){
            node.data = data;
        }
    }

    /**
     * @param index 0-index
     * @return element at position index
     */
    //ve a una direccion,  cuendo lo encuentra, se regresa, si no es igual a data
    public String getAt(int index) {
        Node node = findNode(index);

        return node == null ? null : node.data;
    }

    //LinkedList me crea el Iterator
    public LinkedListIterator getIterator() {
        return new LinkedListIterator(head);// El head es porq va a empezar ahi
    }

    public int getSize() {
        return size;
    }

    private Node findNode(int index) {

        if(index < 0 || index >= size){
            return null;
        }

        Node node = head;
        int currentIndex = 0;

        while (currentIndex != index) {
            currentIndex++;
            node = node.next;
        }

        return node;
    }
}
