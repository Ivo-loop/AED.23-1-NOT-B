package lineares;

public interface Fila<T> {

    void inserir(T v);
    T retirar ();
    T peek();
    boolean estaVazia();
    void liberar();
}
