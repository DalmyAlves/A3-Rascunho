public class Estatisticas {
    private String nomeJogadorOuEquipe;
    private String torneioId;
    private int pontos;
    private int partidasJogadas;
    private int vitorias;
    private int derrotas;
    private int ranking;

    public Estatisticas(String nomeJogadorOuEquipe, String torneioId, int partidasJogadas, int vitorias, int derrotas, int abates, int mortes) {
        this.nomeJogadorOuEquipe = nomeJogadorOuEquipe;
        this.torneioId = torneioId;
        this.partidasJogadas = partidasJogadas;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.pontos = calcularPontuacao();
        this.ranking = ranking;
    }

    private int calcularPontuacao() {
        return (vitorias * 15) + (derrotas * 3);
    }

    public String getNomeJogadorOuEquipe() {
        return nomeJogadorOuEquipe;
    }

    public String getTorneioId() {
        return torneioId;
    }

    public int getPontos() {
        return pontos;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void adicionarVitoria() {
        this.vitorias++;
        this.partidasJogadas++;
        this.pontos = calcularPontuacao();
    }

    public void adicionarDerrota() {
        this.derrotas++;
        this.partidasJogadas++;
        this.pontos = calcularPontuacao();
    }

    public double calcularTaxaVitoria() {
        return partidasJogadas == 0 ? 0 : (double) vitorias / partidasJogadas * 100;
    }

    @Override
    public String toString() {
        return String.format("%s - Torneio %s: %d pts (%dV/%dD)",
                nomeJogadorOuEquipe, torneioId, pontos, vitorias, derrotas);
    }

    public void setRanking ( int ranking ) {
        this.ranking = ranking;
    }

    public int getRanking () {
        return ranking;
    }
}