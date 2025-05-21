package Modelos;

/**
 * Classe que representa as estatísticas de um jogador ou equipe em um torneio.
 * Armazena dados como vitórias, derrotas, pontos e ranking.
 */
public class Estatisticas {
    private String nomeJogadorOuEquipe;
    private String torneioId;
    private int pontos;
    private int partidasJogadas;
    private int vitorias;
    private int derrotas;
    private int ranking;

    /**
     * Construtor da classe. Inicializa os dados da estatística.
     */
    public Estatisticas(String nomeJogadorOuEquipe, String nomeTorneio, int partidasJogadas, int vitorias, int derrotas) {
        this.nomeJogadorOuEquipe = nomeJogadorOuEquipe;
        this.torneioId = nomeTorneio;
        this.partidasJogadas = partidasJogadas;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.pontos = calcularPontuacao();
    }

    /**
     * Calcula a pontuação com base nas vitórias e derrotas.
     * Exemplo: vitória vale 15 pts, derrota vale 3 pts.
     */
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

    /**
     * Adiciona uma vitória e atualiza os pontos e partidas jogadas.
     */
    public void adicionarVitoria() {
        this.vitorias++;
        this.partidasJogadas++;
        this.pontos = calcularPontuacao();
    }

    /**
     * Adiciona uma derrota e atualiza os pontos e partidas jogadas.
     */
    public void adicionarDerrota() {
        this.derrotas++;
        this.partidasJogadas++;
        this.pontos = calcularPontuacao();
    }

    /**
     * Calcula a porcentagem de vitórias em relação ao total de partidas jogadas.
     */
    public double calcularTaxaVitoria() {
        return partidasJogadas == 0 ? 0 : (double) vitorias / partidasJogadas * 100;
    }

    @Override
    public String toString() {
        return String.format("%s - Torneio %s: %d pts (%dV/%dD)",
                nomeJogadorOuEquipe, torneioId, pontos, vitorias, derrotas);
    }

    /**
     * Define o ranking do jogador/equipe.
     */
    public void setRanking ( int ranking ) {
        this.ranking = ranking;
    }

    /**
     * Retorna o ranking do jogador/equipe.
     */
    public int getRanking () {
        return ranking;
    }
}