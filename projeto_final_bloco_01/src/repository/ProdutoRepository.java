package repository;

import modelo.Produto;
import java.util.List;
import java.util.ArrayList;

public class ProdutoRepository implements Repository {
    private List<Produto> produtos;

    public ProdutoRepository() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void criarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public Produto lerProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void atualizarProduto(Produto produto) {
        Produto existente = lerProduto(produto.getId());
        if (existente != null) {
            existente.setNome(produto.getNome());
            existente.setPreco(produto.getPreco());
        }
    }

    @Override
    public void deletarProduto(int id) {
        Produto produto = lerProduto(id);
        if (produto != null) {
            produtos.remove(produto);
        }
    }
}
