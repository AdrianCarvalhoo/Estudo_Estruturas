package src.fila;

public class Fila<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // A fila está vazia
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>();
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Tamanho da fila: " + fila.size());
        System.out.println("Elemento na frente: " + fila.peek());

        while (!fila.isEmpty()) {
            System.out.println("Elemento removido: " + fila.dequeue());
        }
    }
}
