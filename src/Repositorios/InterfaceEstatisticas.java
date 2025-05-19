package Repositorios;

import Modelos.Estatisticas;

public interface InterfaceEstatisticas {


    String getNomeJogadorOuEquipe();
    String getTorneioId();
    int getPontos();
    int getPartidasJogadas();
    int getVitorias();
    int getDerrotas();
    int getRanking();
    void adicionarVitoria();
    void adicionarDerrota();
    double calcularTaxaVitoria();
    void setRanking(int ranking);

    @Override
    String toString();
}
