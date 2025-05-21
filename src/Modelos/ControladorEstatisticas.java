package Modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ControladorEstatisticas {
    private List<Estatisticas> estatisticasList;

    public ControladorEstatisticas() {
        this.estatisticasList = new ArrayList<>();
    }

    public void atualizarRanking() {
        Collections.sort(estatisticasList, Comparator.comparingInt(Estatisticas::getPontos).reversed());

        for (int i = 0; i < estatisticasList.size(); i++) {
            estatisticasList.get(i).setRanking(i + 1);
        }
    }

    public List<Estatisticas> filtrarPorTorneio(String torneioId) {
        List<Estatisticas> resultado = new ArrayList<>();
        for (Estatisticas estatistica : estatisticasList) {
            if (estatistica.getNomeTorneio().equals(torneioId)) {
                resultado.add(estatistica);
            }
        }
        return resultado;
    }

    public void registrarVitoria(String nomeJogadorOuEquipe, String torneioId) {
        Estatisticas estatistica = buscarOuCriarEstatistica(nomeJogadorOuEquipe, torneioId);
        estatistica.adicionarVitoria();
        atualizarRanking();
    }

    public void registrarDerrota(String nomeJogadorOuEquipe, String torneioId) {
        Estatisticas estatistica = buscarOuCriarEstatistica(nomeJogadorOuEquipe, torneioId);
        estatistica.adicionarDerrota();
        atualizarRanking();
    }


    private Estatisticas buscarOuCriarEstatistica(String nomeJogadorOuEquipe, String torneioId) {
        for (Estatisticas estatistica : estatisticasList) {
            if (estatistica.getNomeJogadorOuEquipe().equals(nomeJogadorOuEquipe) &&
                    estatistica.getNomeTorneio().equals(torneioId)) {
                return estatistica;
            }
        }

        Estatisticas novaEstatistica = new Estatisticas(
                nomeJogadorOuEquipe, torneioId, 0, 0, 0);
        estatisticasList.add(novaEstatistica);
        return novaEstatistica;
    }

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

    public List<Estatisticas> getEstatisticasList() {
        return estatisticasList;
    }
}