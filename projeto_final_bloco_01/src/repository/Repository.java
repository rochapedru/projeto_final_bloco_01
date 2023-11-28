package repository;

import modelo.Produto;

public interface Repository {
    void criarProduto(Produto produto); // Create
    Produto lerProduto(int id); // Read
    void atualizarProduto(Produto produto); // Update
    void deletarProduto(int id); // Delete
}
