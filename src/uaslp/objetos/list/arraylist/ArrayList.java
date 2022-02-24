package uaslp.objetos.list.arraylist;

public class ArrayList {

    //Como se declaran constantes en java -> static final
    private static final int DEFAULT_SIZE = 50;
    private String[] array;
    private int size;

    //Sobrecarga: varios metodos con nombre == q se ddiferencian por parametros, sobrecargamos constructores
    //Si creo un arreglo sin size me da uno de 50
    public ArrayList (){
        array = new String[DEFAULT_SIZE];
    }

    public ArrayList (int size){
        array = new String[size];
    }

    //Agregar a la cola
    public void addAtTail(String data) {
        if(size == array.length){
            increaseArraySize();
        }
    array[size] = data;
    size++;
    }

    //Agregar al frente
    public void addAtFront(String data) {
        if(size == array.length){
            increaseArraySize();
        }

        if(size >= 0){
            System.arraycopy(array, 0, array,1, size);
            //Igual q for(int i=0; i < size; i++) array[0] = data;
        }
        array[0]=data;
        size++;
    }

    //se recorren datos y se disminuye size
    public void remove(int index) {
        if(index <0 || index >= size){
            return;
        }

        for( int i= index ; i<size-1; i++) {
            array[i] = array[i+1];
        }
        array[size -1] = null; // para q garbage colector detecte los objetos mas rapido
        size--;
    }

    public void removeAll() {
            for( int i= 0; i<size-1; i++) {
                array[i] = null;
            }
            size =0;
    }

    public void setAt(int index, String data) {
        if(index >= 0 && index < size){
            array[index] = data;
        }
    }


    //ve a una direccion,  cuendo lo encuentra, se regresa, si no es igual a data
    public String getAt(int index) {
        return index >= 0 && index < size ? array[index] : null ;
    }

    //LinkedList me crea el Iterator
    public ArrayListIterator getIterator() {
        return new ArrayListIterator(this); // el this para saber donde va a iterar, en el objeto q esta creando, es decir this
    }

    public int getSize() {
        return size;
    }

    private void increaseArraySize(){
        String[]newArray = new String[array.length*2];

        for(int i=0; i < size; i++ ){
            newArray[i]=array[i];
        }
        array = newArray;
    }


}
