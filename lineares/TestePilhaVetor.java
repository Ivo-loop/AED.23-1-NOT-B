package lineares;

public class TestePilhaVetor {
    public static void main(String[] args) {
        Pilha pilha = new PilhaVetor(10);
        for (int i = 1; i <=10; i++  )
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
