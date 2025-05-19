package Repositorios;

import Modelos.ControladorEstatisticas;
import Modelos.Estatisticas;

import java.util.List;

public interface InterfaceControladorEstatisticas {
    void atualizarRanking();
    List<Estatisticas> filtrarPorTorneio(String torneioId);
    void registrarVitoria(String nomeJogadorOuEquipe, String torneioId);
    void registrarDerrota(String nomeJogadorOuEquipe, String torneioId);
    String exibirRanking();
    List<Estatisticas> getEstatisticasList();
}
