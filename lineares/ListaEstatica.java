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
		int[] novo = new int[info.length + 10];
		for (int i = 0; i < info.length; i++) {
			novo[i] = info[i];
		}
		this.info = novo;
	}

	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
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
			for (int i = pos; i < tamanho - 1; i++) {
				info[i] = info[i + 1];
			}
			this.tamanho--;
		}
	}

	public String exibir() {
		String str = "[";
		for (int i = 0; i < tamanho; i++) {
			str += info[i] + ", ";
		}
		return str + "]";
	}

	public ListaEstatica copiar() { // contribuição Maria Clara
		ListaEstatica outra = new ListaEstatica();
		for (int i = 0; i < this.tamanho; i++) {
			outra.inserir(this.info[i]);
		}

		return outra;
	}

	public ListaEstatica dividir() {
		int metade = this.tamanho / 2;
		ListaEstatica outra = new ListaEstatica();
		for (int i = metade; i < this.tamanho; i++) {
			outra.inserir(this.info[i]);
		}
		this.tamanho = metade;
		return outra;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public void concatenar(ListaEstatica outraLista) {
		for (int i = 0; i < outraLista.getTamanho(); i++) {
			this.inserir(outraLista.pegar(i));
		}
	}

	public int pegar(int pos) {
		if (pos >= this.tamanho) {
			throw new IndexOutOfBoundsException("Pos="+pos+". Length="+tamanho);
		}
		return this.info[pos];
	}

}
