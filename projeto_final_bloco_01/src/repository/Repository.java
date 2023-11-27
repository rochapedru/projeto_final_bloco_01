
public interface Repository {
    void salvar();
    void deletar();
    void atualizar();
}

public class Loja implements Repository {
    @Override
    public void salvar() {

    }

    @Override
    public void deletar() {

    }

    @Override
    public void atualizar() {

    }
}


public class Produto implements Repository {


    @Override
    public void salvar() {
    
    }

    @Override
    public void deletar() {
        
    }

    @Override
    public void atualizar() {
        
    }
}


public class Utils implements Repository {
  

    @Override
    public void salvar() {
       
    }

    @Override
    public void deletar() {
        // implementation of delete method
    }

    @Override
    public void atualizar() {
        // implementation of update method
    }
}
