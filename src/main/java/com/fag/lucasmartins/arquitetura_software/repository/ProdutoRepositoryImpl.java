import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Override
    public Produto salvar(Produto produto) {
        return produto;
    }
}