public class Estatisticas {
    private String nomeJogadorOuEquipe;
    private String torneioId;
    private int pontos;
    private int partidasJogadas;

    public Estatisticas(String nomeJogadorOuEquipe, String torneioId, int pontos, int partidasJogadas) {
        this.nomeJogadorOuEquipe = nomeJogadorOuEquipe;
        this.torneioId = torneioId;
        this.pontos = pontos;
        this.partidasJogadas =partidasJogadas;
    }

    public String getNomeJogadorOuEquipe() {
        return nomeJogadorOuEquipe;
    }

    public void setNomeJogadorOuEquipe(String nomeJogadorOuEquipe) {
        this.nomeJogadorOuEquipe = nomeJogadorOuEquipe;
    }

    public String getTorneioId() {
        return torneioId;
    }

    public void setTorneioId(String torneioId) {
        this.torneioId = torneioId;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

}
