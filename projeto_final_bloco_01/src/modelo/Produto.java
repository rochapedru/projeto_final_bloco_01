package modelo;

import utils.Utils;

public class Produto {
	// contar o numero de produtos
	private static int count = 1;
	// definicao de um produto
	private int id;
	private String nome;
	private Double preco;
	
	// criar construtores using fields, nao precida do id
	// pq ele vai receber no contador
	public Produto(String nome, Double preco) {
		// so add o id que recebe o count
		this.id = Produto.count;
		this.nome = nome;
		this.preco = preco;
		// os produtos vao se criados como
		// id 2, id2, id3, etc..
		Produto.count += 1;
	}
	// criando getters and settles 

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String toString() {
		return " id: " + this.getId() +
				"\nNome: " + this.getNome() +
				"\nPreco: " + Utils.doubleToString(this.getPreco());
	}
	
	
	

}
