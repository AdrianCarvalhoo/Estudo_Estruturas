package src.pilha;

public class Pilha<T> {
    private Node<T> top;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);

        System.out.println("Tamanho da pilha: " + pilha.size());
        System.out.println("Elemento no topo: " + pilha.peek());

        while (!pilha.isEmpty()) {
            System.out.println("Elemento removido: " + pilha.pop());
        }
    }
}
