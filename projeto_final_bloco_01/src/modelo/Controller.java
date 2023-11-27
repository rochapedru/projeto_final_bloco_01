package modelo;
import modelo.Produto;
import java.util.List;
import repository.Repository;
import utils.Utils;
import main.Loja;

public class Controller {
    // Supondo que produtos seja uma lista de produtos
    private List<Produto> produtos;

    public String listarProdutos() {
        StringBuilder sb = new StringBuilder();
        if (produtos.size() > 0) {
            sb.append("Lista de produtos! \n");
            for(Produto p : produtos) {
                sb.append(p.toString()).append("\n");
            }
        } else {
            sb.append("Nenhum Produto Cadastrado");
        }
        return sb.toString();
    }
}