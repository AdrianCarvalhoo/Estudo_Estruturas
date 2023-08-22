package src.lista;

public class ListaEncadeada<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }
        return current.data;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);

        System.out.println("Tamanho da lista: " + lista.size());

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Elemento na posição " + i + ": " + lista.get(i));
        }
    }
}
