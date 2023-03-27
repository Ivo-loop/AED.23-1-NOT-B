package lineares;

import java.util.Arrays;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        tamanho = 0;
        this.limite = limite;
        info = (T[]) new Object[limite];
    }

    @Override
    public String toString() {
        return Arrays.toString(info);
    }

    @Override
    public void push(T v) {
        if (limite == tamanho) {
            throw new RuntimeException("Capacidade esgotada da pilha");
        }
        info[tamanho] = v;
        tamanho++;
    }

    @Override
    public T pop() {
        T v = peek();
        info[tamanho-1]=null;
        tamanho--;
        return v;
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new RuntimeException("Pilha está vazia");
        return info[tamanho - 1];
    }

    public boolean estaVazia() {
        return (tamanho == 0);
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }
}
