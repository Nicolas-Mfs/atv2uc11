package model;

public class Item {
    private String nome;
    private double valorInicial;

    // Construtor
    public Item(String nome, double valorInicial) {
        this.nome = nome;
        this.valorInicial = valorInicial;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }
}
