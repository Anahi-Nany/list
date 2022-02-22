package uaslp.objetos.list.linkedlist;

//Modificador de acceso

// El soporte a el pilar: Encapsulación
// private
// public
// package-private / default

class Node {//  -> Las clases solo pueden ser públicas o package-private
    String data;
    Node next;
    Node previous;

    Node(String data) {
        this.data = data;
    }
}