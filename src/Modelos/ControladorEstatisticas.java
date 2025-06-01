package Modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
     * Atualiza o ranking dos jogadores/equipes com base nos pontos, DENTRO DE CADA TORNEIO.
     * Agrupa as estatísticas por torneio, ordena cada grupo e define a posição (ranking) de cada um.
     */
    public void atualizarRanking() {
        // Agrupa as estatísticas por ID do torneio
        Map<String, List<Estatisticas>> estatisticasPorTorneio = estatisticasList.stream()
                .collect(Collectors.groupingBy(Estatisticas::getNomeTorneio));

        // Para cada torneio, ordena os participantes e atribui os rankings
        for (List<Estatisticas> statsDoTorneio : estatisticasPorTorneio.values()) {
            // Ordena por pontos em ordem decrescente
            statsDoTorneio.sort(Comparator.comparingInt(Estatisticas::getPontos).reversed());

            // Define o ranking para cada estatística dentro deste torneio específico
            for (int i = 0; i < statsDoTorneio.size(); i++) {
                statsDoTorneio.get(i).setRanking(i + 1);
            }
        }
        // A lista principal 'estatisticasList' não é reordenada globalmente,
        // mas os objetos Estatisticas dentro dela agora têm seus rankings específicos do torneio.
    }

    /**
     * Filtra as estatísticas apenas para um determinado torneio.
     * @param nomeTorneio Nome ou ID do torneio
     * @return Lista de estatísticas referentes ao torneio informado
     */
    public List<Estatisticas> filtrarPorTorneio(String nomeTorneio) {
        return estatisticasList.stream()
                .filter(e -> e.getNomeTorneio().equalsIgnoreCase(nomeTorneio))
                .collect(Collectors.toList());
    }

    /**
     * Registra uma vitória para o jogador/equipe em um torneio específico.
     * @param nomeJogadorOuEquipe Nome do jogador ou equipe
     * @param torneioId Nome ou ID do torneio
     */
    public void registrarVitoria(String nomeJogadorOuEquipe, String torneioId) {
        Estatisticas estatistica = buscarOuCriarEstatistica(nomeJogadorOuEquipe, torneioId);
        estatistica.adicionarVitoria();
        atualizarRanking(); // Atualiza os rankings considerando a separação por torneio
    }

    /**
     * Registra uma derrota para o jogador/equipe em um torneio específico.
     * @param nomeJogadorOuEquipe Nome do jogador ou equipe
     * @param nomeTorneio Nome ou ID do torneio
     */
    public void registrarDerrota(String nomeJogadorOuEquipe, String nomeTorneio) {
        Estatisticas estatistica = buscarOuCriarEstatistica(nomeJogadorOuEquipe, nomeTorneio);
        estatistica.adicionarDerrota();
        atualizarRanking(); // Atualiza os rankings considerando a separação por torneio
    }

    /**
     * Busca uma estatística existente ou cria uma nova, caso não exista.
     * @param nomeJogadorOuEquipe Nome do jogador ou equipe
     * @param nomeTorneio Nome ou ID do torneio
     * @return Objeto Estatisticas correspondente
     */
    private Estatisticas buscarOuCriarEstatistica(String nomeJogadorOuEquipe, String nomeTorneio) {
        for (Estatisticas estatistica : estatisticasList) {
            if (estatistica.getNomeJogadorOuEquipe().equalsIgnoreCase(nomeJogadorOuEquipe) &&
                    estatistica.getNomeTorneio().equalsIgnoreCase(nomeTorneio)) {
                return estatistica;
            }
        }

        // Se não encontrar, cria nova estatística
        Estatisticas novaEstatistica = new Estatisticas(
                nomeJogadorOuEquipe, nomeTorneio, 0, 0, 0);
        estatisticasList.add(novaEstatistica);
        return novaEstatistica;
    }

    /**
     * Retorna os rankings de todos os torneios como uma String formatada.
     * @return String com os rankings separados por torneio
     */
    public String exibirRanking() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== RANKINGS POR TORNEIO =====\n");

        if (estatisticasList.isEmpty()) {
            sb.append("Nenhuma estatística registrada.\n");
            return sb.toString();
        }

        // Agrupa as estatísticas por torneio para exibição
        Map<String, List<Estatisticas>> estatisticasPorTorneio = estatisticasList.stream()
                .collect(Collectors.groupingBy(Estatisticas::getNomeTorneio));

        // Ordena os nomes dos torneios para exibição consistente (opcional)
        List<String> nomesTorneiosOrdenados = new ArrayList<>(estatisticasPorTorneio.keySet());
        Collections.sort(nomesTorneiosOrdenados);

        for (String nomeTorneio : nomesTorneiosOrdenados) {
            sb.append("\n--- RANKING TORNEIO: ").append(nomeTorneio.toUpperCase()).append(" ---\n");
            List<Estatisticas> statsDoTorneio = estatisticasPorTorneio.get(nomeTorneio);

            // Ordena pela posição no ranking (que foi definida em atualizarRanking)
            // ou por pontos, se preferir recalcular a ordem aqui.
            statsDoTorneio.sort(Comparator.comparingInt(Estatisticas::getRanking));

            if (statsDoTorneio.isEmpty()) {
                sb.append("  Nenhum participante neste torneio.\n");
            } else {
                for (Estatisticas estatistica : statsDoTorneio) {
                    sb.append(String.format("  #%d - %s: %d pts (%dV/%dD)\n",
                            estatistica.getRanking(), // Usa o ranking específico do torneio
                            estatistica.getNomeJogadorOuEquipe(),
                            estatistica.getPontos(),
                            estatistica.getVitorias(),
                            estatistica.getDerrotas()));
                }
            }
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