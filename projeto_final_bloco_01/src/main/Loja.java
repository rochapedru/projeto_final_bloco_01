package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import modelo.Produto;
import modelo.Controller;
import utils.Utils;

public class Loja {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
	private static Map<Produto, Integer> carrinho;
	private static Controller controller = new Controller();

	public static void main(String[] args) {
		produtos = new ArrayList<>();
		carrinho = new HashMap<>();
		menu();
	}

	private static void menu() {
		System.out.println("1.BIG BANGS PEÇAS DE COMPUTADORES");
		System.out.println("1.Cadastrar. 2.Listas, 3.Comprar por ID do Eletronico, 4- finalizar Comprar, 5.sair");
		int op = input.nextInt();
		switch (op) {
			case 1 -> cadastrarProdutos();
			case 2 -> listarProdutos();
			case 3 -> comprarProdutos();
			case 4 -> finalizarCompra();
			case 5 -> { 
				System.out.println("Saindo do programa");
				System.exit(0);
			} default -> {
				System.out.println("Erro");
				menu(); 
			}
		}
	} 

	private static void cadastrarProdutos() {
		System.out.println("Nome do Produto: ");
		String nome = input.next();
		System.out.println("Preco do produto: ");
		Double preco = input.nextDouble();
		Produto produto = new Produto(nome, preco);
		produtos.add(produto);
		System.out.println(produto.getNome() + " Cadastrato com sucesso");
		menu();
	}	
	
	private static void listarProdutos() {
	    System.out.println(controller.listarProdutos(produtos));
	    menu();
	}
	
	private static void comprarProdutos() {
	    System.out.println("Digite o ID do produto que deseja comprar:  ");
	    int id = Integer.parseInt(input.next());
	    controller.comprarProdutos(produtos, carrinho, id);
	    
	    System.out.println("Deseja continuar comprando? 1 - Sim, 2 - Não");
	    int opcao = Integer.parseInt(input.next());
	    if (opcao == 1) {
	        comprarProdutos();
	    } else {
	        menu();
	    }
	}

	private static void finalizarCompra() {
	    controller.finalizarCompra(carrinho);
	    menu();
	}

}


