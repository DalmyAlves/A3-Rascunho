class Participante {
    private String nome;
    private int vitorias;
    private int derrotas;

    public Participante(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.derrotas = 0;
    }

    public void adicionarVitoria() {
        this.vitorias++;
    }

    public void adicionarDerrota() {
        this.derrotas++;
    }

    public int calcularPontos() {
        return (vitorias * 15) + (derrotas * 3);
    }

    public String getNome() {
        return nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }
}