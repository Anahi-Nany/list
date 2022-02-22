package uaslp.objetos.list.linkedlist;

public class LinkedListIterator {

    private Node currentNode; //referencia para q este se mueva


    LinkedListIterator(Node startNode) {
        currentNode = startNode;
    }

    //le digo que siga cuando no sea null
    public boolean hasNext() {
        return currentNode != null;
    }

    public String next() {
        String data = currentNode.data; //obtener el dato q q apunta y current data se guarda

        currentNode = currentNode.next;//avanzo

        return data;
    }
}
