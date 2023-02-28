package lineares;

public class ListaEstatica {
	private int[] info;
	private int tamanho;
	
	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}
	
	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	private void redimensionar() {
		int[] novo = new int[info.length+10];
		for (int i=0; i < info.length; i++) {
			novo[i] = info[i];
		}
		this.info = novo;
	}
	
	public int buscar(int valor) {
		for (int i=0; i < tamanho; i++) {
			if (valor == info[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean estaVazia() {
		return (tamanho == 0);
	}
	
	public void retirar(int valor) {
		int pos = this.buscar(valor);
		if (pos != -1) { // encontrou o valor
			for (int i=pos; i < tamanho-1; i++) {
				info[i] = info[i+1];
			}
			this.tamanho--;
		}
	}
}
