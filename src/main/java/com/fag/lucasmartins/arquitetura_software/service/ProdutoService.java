import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criarProduto(ProdutoRequestDTO dto) {

        Produto produto = new Produto(
            dto.nome,
            dto.preco,
            dto.premium,
            dto.quantidade
        );

        produto.aplicarRegras();

        return repository.salvar(produto);
    }
}