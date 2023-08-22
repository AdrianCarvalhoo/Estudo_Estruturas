package src.lista;

public class ListaSequencial<T> {
    private Object[] elements;
    private int size;
    private int capacity;

    public ListaSequencial(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public void add(T data) {
        if (size < capacity) {
            elements[size] = data;
            size++;
        } else {
            throw new IllegalStateException("A lista está cheia.");
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elements[index];
        } else {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ListaSequencial<Integer> lista = new ListaSequencial<>(5);
        lista.add(10);
        lista.add(20);
        lista.add(30);

        System.out.println("Tamanho da lista: " + lista.size());

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Elemento na posição " + i + ": " + lista.get(i));
        }
    }
}
