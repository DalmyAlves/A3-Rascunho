package Modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe responsável por controlar e gerenciar as estatísticas dos jogadores ou equipes.
 * Aqui são feitas operações como atualizar ranking, registrar vitórias/derrotas e filtrar estatísticas.
 */
public class ControladorEstatisticas {
    // Lista que armazena as estatísticas de todos os jogadores ou equipes
    private List<Estatisticas> estatisticasList;

    /**
     * Construtor da classe. Inicializa a lista de estatísticas.
     */
    public ControladorEstatisticas() {
        this.estatisticasList = new ArrayList<>();
    }

    /**
     * Atualiza o ranking dos jogadores/equipes com base nos pontos.
     * Ordena a lista e define a posição (ranking) de cada um.
     */
    public void atualizarRanking() {
        Collections.sort(estatisticasList, Comparator.comparingInt(Estatisticas::getPontos).reversed());

        // Após ordenar, define o ranking de cada estatística
        for (int i = 0; i < estatisticasList.size(); i++) {
            estatisticasList.get(i).setRanking(i + 1);
        }
    }

    /**
     * Filtra as estatísticas apenas para um determinado torneio.
     * @param torneioId Nome ou ID do torneio
     * @return Lista de estatísticas referentes ao torneio informado
     */
    public List<Estatisticas> filtrarPorTorneio(String torneioId) {
        List<Estatisticas> resultado = new ArrayList<>();
        for (Estatisticas estatistica : estatisticasList) {
            if (estatistica.getNomeTorneio().equals(torneioId)) {
                resultado.add(estatistica);
            }
        }
        return resultado;
    }

    /**
     * Registra uma vitória para o jogador/equipe em um torneio específico.
     * @param nomeJogadorOuEquipe Nome do jogador ou equipe
     * @param torneioId Nome ou ID do torneio
     */
    public void registrarVitoria(String nomeJogadorOuEquipe, String torneioId) {
        Estatisticas estatistica = buscarOuCriarEstatistica(nomeJogadorOuEquipe, torneioId);
        estatistica.adicionarVitoria();
        atualizarRanking();
    }

    /**
     * Registra uma derrota para o jogador/equipe em um torneio específico.
     * @param nomeJogadorOuEquipe Nome do jogador ou equipe
     * @param torneioId Nome ou ID do torneio
     */
    public void registrarDerrota(String nomeJogadorOuEquipe, String torneioId) {
        Estatisticas estatistica = buscarOuCriarEstatistica(nomeJogadorOuEquipe, torneioId);
        estatistica.adicionarDerrota();
        atualizarRanking();
    }

    /**
     * Busca uma estatística existente ou cria uma nova, caso não exista.
     * @param nomeJogadorOuEquipe Nome do jogador ou equipe
     * @param torneioId Nome ou ID do torneio
     * @return Objeto Estatisticas correspondente
     */
    private Estatisticas buscarOuCriarEstatistica(String nomeJogadorOuEquipe, String torneioId) {
        for (Estatisticas estatistica : estatisticasList) {
            if (estatistica.getNomeJogadorOuEquipe().equals(nomeJogadorOuEquipe) &&
                    estatistica.getNomeTorneio().equals(torneioId)) {
                return estatistica;
            }
        }

        // Se não encontrar, cria nova estatística
        Estatisticas novaEstatistica = new Estatisticas(
                nomeJogadorOuEquipe, torneioId, 0, 0, 0);
        estatisticasList.add(novaEstatistica);
        return novaEstatistica;
    }

    /**
     * Retorna o ranking de todos os jogadores/equipes como uma String formatada.
     * @return String com o ranking
     */
    public String exibirRanking() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== RANKING =====\n");
        for (Estatisticas estatistica : estatisticasList) {
            sb.append(String.format("#%d - %s\n",
                    estatistica.getRanking(),
                    estatistica.toString()));
        }
        return sb.toString();
    }

    /**
     * Retorna a lista de estatísticas (usado para consultas).
     */
    public List<Estatisticas> getEstatisticasList() {
        return estatisticasList;
    }
}