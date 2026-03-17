public class Produto {

    private String nome;
    private Double preco;
    private Boolean premium;
    private Integer quantidade;

    public Produto(String nome, Double preco, Boolean premium, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.premium = premium;
        this.quantidade = quantidade;
    }

    public void aplicarRegras() {
        if (premium) {
            preco *= 1.2;
        }
        if (quantidade > 10) {
            preco *= 0.9;
        }
    }

    public Double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}