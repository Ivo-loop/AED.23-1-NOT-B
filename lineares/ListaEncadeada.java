package lineares;

public class ListaEncadeada<T> implements Lista<T> {

	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElementos;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElementos++;
	}

	@Override
	public void inserir(T valor, int pos) {
		NoLista<T> atual = new NoLista<>();
		NoLista<T> proximo = new NoLista<>();
		NoLista<T> anterior = new NoLista<>();
		if (pos == 0) {
			proximo = this.primeiro;
			atual.setInfo(valor);
			atual.setProximo(proximo);
			primeiro = atual;
		} else {
			for (int i = 1; i <= pos; i++) {
				anterior = proximo;
				proximo = proximo.getProximo();
			}

			atual.setInfo(valor);
			anterior.setProximo(atual);
			if (pos != getTamanho())
				atual.setProximo(proximo);
		}
		qtdElementos++;
	}

	@Override
	public int buscar(T valor) { // contribuição da Maria Julia
		NoLista<T> p = primeiro;
		int cont = 0;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return cont;
			}
			p = p.getProximo();
			cont++;
		}
		return -1;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public void retirar(T valor) { // contribuição do Carlos
		NoLista<T> before = null;
		NoLista<T> current = this.primeiro;
		while (current != null && !current.getInfo().equals(valor)) {
			before = current;
			current = current.getProximo();
		}

		if (current != null) {
			if (before == null) {
				this.primeiro = this.primeiro.getProximo();
			} else {
				before.setProximo(current.getProximo());
			}
			if (this.ultimo == current) {
				this.ultimo = before;
			}
			this.qtdElementos--;
		}
	}

	@Override
	public String exibir() { // contribuição do Jonathan
		NoLista<T> p = primeiro;
		StringBuilder str = new StringBuilder("[");
		while (p != null) {
			str.append(p.getInfo());
			p = p.getProximo();
			if (p != null)
				str.append(", ");
		}
		return str + "]";
	}

	@Override
	public Lista<T> copiar() { // contribuição do Rodrigo
		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		for (NoLista<T> no = this.primeiro; no != null; no = no.getProximo()) {
			novaLista.inserir(no.getInfo());
		}
		return novaLista;
	}

	@Override
	public Lista<T> dividir() { // contribuição do Jonathan
		ListaEncadeada<T> downNova = new ListaEncadeada<>();
		NoLista<T> atual = this.primeiro;
		NoLista<T> anterior = null;
		for (int i = 0; i < this.getTamanho() / 2; i++) {
			anterior = atual;
			atual = atual.getProximo();
		}
		downNova.primeiro = atual;
		downNova.ultimo = this.ultimo;
		this.ultimo = anterior;
		anterior.setProximo(null);
		downNova.qtdElementos = this.getTamanho() - (this.getTamanho() / 2);
		this.qtdElementos = this.getTamanho() / 2;

		return downNova;
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	@Override
	public void concatenar(Lista<T> outraLista) {
		for (int i = 0; i < outraLista.getTamanho(); i++) {
			this.inserir(outraLista.pegar(i));
		}
	}

	@Override
	public T pegar(int pos) {
		if (pos < 0 || pos >= this.qtdElementos) {
			throw new IndexOutOfBoundsException("Pos=" + pos);
		}
		NoLista<T> p = this.primeiro;
		int posicao = 0;
		while (p != null) {
			if (posicao == pos) {
				return p.getInfo();
			}
			posicao++;
			p = p.getProximo();
		}
		return null; // nunca deveria chegar aqui
	}

}
