package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import modelo.Produto;
import utils.Utils;
public class Loja {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
	private static Map<Produto, Integer> carrinho;
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
	case 4 -> verCarrinho();
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
		if (produtos.size() > 0) {
			System.out.println("Lista de produtos! \n");
			for(Produto p : produtos) {
				System.out.println(p);
			}
		}else {
			System.out.println("Nenhum Produto Cadastrado");
		}
		menu();
	}
	private static void comprarProdutos() {
		if (produtos.size() > 0) {
			System.out.println("codigo do produtos! \n");
			System.out.println("Produtos Disponiveis \n");
			for(Produto p : produtos) {
				System.out.println(p + "\n");
			}       
			int id = Integer.parseInt(input.next());
			boolean isPresent = false;
			for (Produto p : produtos) {
				if (p.getId() == id) {
					int qtd = 0;
					try {
						qtd = carrinho.get(p);
						carrinho.put(p, qtd +1);
					}catch (NullPointerException e) {
						carrinho.put(p, 1);
					}
					System.out.println(p.getNome() + " adiconado ao carrinho" );
					isPresent = true;
					break; // break the loop once the product is found
            }
        }
        if (!isPresent) {
            System.out.println("Eletronico ou peca nao encontrada");
            menu();
        } else {
            System.out.println("Adicionar outro eletronico, 1-sim, 2-nao");
            int option = Integer.parseInt(input.next());
            if (option == 1) {
                comprarProdutos();
            }else {
                finalizarCompra();
            }
        }
    } else {
        System.out.println("Eletronico ou peça ainda nao cadastrado");
        menu();
    }   
}

	private static void verCarrinho() {
		System.out.println("Eletronico no carrinho de pedidos");
		if (carrinho.size() > 0) {
			for ( Produto p : carrinho.keySet()) {
				System.out.println("Eletronicos: " + p + "\nQuantidades: " + carrinho.get(p));
			}
		}else {
			System.out.println("Carrinho vazio");
		}
		menu();
	}
	private static void finalizarCompra() {
		Double valorDaCompra = 0.0;
		System.out.println("OS Pedidos: ");

		for (Produto p : carrinho.keySet()) {
			int qtd = carrinho.get(p);
			valorDaCompra += p.getPreco() * qtd;
			System.out.println(p);
			System.out.println("Quantidades: " + qtd);
		}
		System.out.println("O valor da sua compra é: " + Utils.doubleToString(valorDaCompra));
		carrinho.clear();
		menu();
	}
}


