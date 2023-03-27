package lineares;

public class TestePilhaLista {
    public static void main(String[] args) {
        Pilha pilha = new PilhaLista();
        for (int i = 1; i <= 10; i++)
            pilha.push(i);
        System.out.println(pilha);
        System.out.println(pilha.peek());
        System.out.println(pilha.pop());
        System.out.println(pilha);
        System.out.println(pilha.pop());
        System.out.println(pilha);
        System.out.println(pilha.peek());
        pilha.liberar();
        System.out.println(pilha.estaVazia());
        System.out.println(pilha);
    }
}
