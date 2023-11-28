package modelo;
import java.util.List;
import java.util.Map;
import utils.Utils;
public class Controller {
    private List<Produto> produtos;
    public String listarProdutos(List<Produto> produtos) {
        StringBuilder sb = new StringBuilder();
        if (produtos.size() > 0) {
            sb.append("Lista de produtos! \n");
            for(modelo.Produto p : produtos) {
                sb.append(p.toString()).append("\n");
            }
        } else {
            sb.append("Nenhum Produto Cadastrado");
        }
        return sb.toString();
    }
    public void comprarProdutos(List<Produto> produtos, Map<Produto, Integer> carrinho, int id) {
        if (produtos.size() > 0) {
            System.out.println("Produtos Disponiveis \n");
            for(Produto p : produtos) {
                System.out.println(p + "\n");
            }       
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
        }
    }
    public void finalizarCompra(Map<Produto, Integer> carrinho) {
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
    }
}