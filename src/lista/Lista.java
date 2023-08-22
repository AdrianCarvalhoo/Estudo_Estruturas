package src.lista;

public class Lista {
    private int tamanhoMaximo;
    private int tamanhoAtual;
    private int[] elementos;

    public Lista(int capacidade) {
        tamanhoMaximo = capacidade;
        tamanhoAtual = 0;
        elementos = new int[tamanhoMaximo];
    }

    public void adicionar(int elemento) {
        if (tamanhoAtual < tamanhoMaximo) {
            elementos[tamanhoAtual] = elemento;
            tamanhoAtual++;
        } else {
            System.out.println("A lista está cheia. Não é possível adicionar mais elementos.");
        }
    }

    public void remover(int indice) {
        if (indice >= 0 && indice < tamanhoAtual) {
            for (int i = indice; i < tamanhoAtual - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            tamanhoAtual--;
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void imprimir() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanhoAtual; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lista lista = new Lista(5);

        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.imprimir();

        lista.remover(1);
        lista.imprimir();
    }
}
