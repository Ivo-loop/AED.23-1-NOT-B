package lineares;

public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<>();
    }

    public int getTamanho() {
        return lista.getTamanho();
    }

    @Override
    public String toString() {
        return lista.exibir();
    }

    @Override
    public void push(T v) {
        lista.inserir(v);
    }

    @Override
    public T pop() {
        T v = peek();
        lista.retirar(v);
        return v;
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new RuntimeException("Pilha está vazia");
        return lista.pegar(lista.getTamanho() - 1);
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<T>();
    }
}
