package projeto_final_bloco_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modelo.Produto;

public class menuEletronicos {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
	
	//Metodo para carrinho de compras
	// valor vai ser a quantidade
	private static Map<Produto, Integer> carrinho;
	
	public static void main(String[] args) {
		produtos = new ArrayList<>();
		//interface q implementa o map 
		carrinho = new HashMap<>();
		//menu que a gente ainda vai criar
		menu();
		
	}
	//O menuzinho
	
	private static void menu() {
		System.out.println("1.Cadastrar pedidos ");
		System.out.println("2.Listas eletronicos");
		System.out.println("3.Comprar eletronicos ");
		System.out.println("4.Carrinho ");
		System.out.println("5.sair");
		
		int op = input.nextInt();
		
		switch (op) {
		case 1: 
			cadastrarProdutos();
			break;
		case 2: 
			listarProdutos();
			break;
		case 3: 
			comprarProdutos();
			break;
		case 4: 
			verCarrinho();
			break;
		case 5:
			System.out.println("Volte sempre");
			System.exit();
		default:
			System.out.println("Opcao Invalida");
			menu();
			break;
		}
	
		
	}
	private static void cadastrarProdutos() {
		System.out.println("Nome do Produto: ");
		String nome = input.next();
		
		System.out.println("Preco do produto: ");
		Double preco = input.nextDouble();
		
		// Instanciar nosso produto
		Produto produto = new Produto(nome, preco);
		
		//adicioanr na nossa array produtos
		produtos.add(produto);

		System.out.println(produto.getNome() + " Cadastrato com sucesso");
		menu();
	}
	
	private static void listarProdutos() {
		//Verificar se nao estavazia
		if (produtos.size() > 0) {
			System.out.println("Lista de produtos! \n");
			
			//Percorrer, e mostrar cada produto
			for(Produto p : produtos) {
				System.out.println(p);
				
			}
		}else {
			System.out.println("Nenhum Produto Cadastrado");
		}
		
		menu();
	}
	private static void comprarProdutos() {
		// Verificar se temos o produto no mercado
		// entao para comecar
		// copiar de listar produtos
		if (produtos.size() > 0) {
			System.out.println("codigo do produtos! \n");
			
			System.out.println("Produtos Disponiveis \n");
			//Para cada produtos, na lista de produto, eu mostro produto
			for(Produto p : produtos) {
				System.out.println(p + "\n");
				
			}
			
			int id = Integer.parseInt(input.next());
			boolean isPresent = false;
			
			for (produto p : produtos) {
				if ()
			}
			
		}
		
	}
}
