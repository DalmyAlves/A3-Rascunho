package Repositorios.Listas;

import Modelos.Estatisticas;
import Repositorios.InterfaceRepoListasEstatiscas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepoListaEstatisticas implements InterfaceRepoListasEstatiscas {
    private List<Estatisticas> estatisticas = new ArrayList<>();

    public void adicionar(Estatisticas estatistica) {
        estatisticas.add(estatistica);
    }

    public List<Estatisticas> listarTodos() {
        return new ArrayList<>(estatisticas);
    }

    public Optional<Estatisticas> buscarPorNomeETorneio(String nome, String torneioId) {
        return estatisticas.stream()
                .filter(e -> e.getNomeJogadorOuEquipe().equals(nome)
                        && e.getTorneioId().equals(torneioId))
                .findFirst();
    }

    public boolean atualizarEstatisticas (Estatisticas estatisticaAtualizada) {
        boolean atualizar = false;
        for (int i = 0; i < estatisticas.size(); i++) {
            Estatisticas e = estatisticas.get(i);
            if (e.getNomeJogadorOuEquipe().equals(estatisticaAtualizada.getNomeJogadorOuEquipe())
                    && e.getTorneioId().equals(estatisticaAtualizada.getTorneioId())) {
                estatisticas.set(i, estatisticaAtualizada);
                atualizar = true;
            }
        }
        return atualizar;
    }

    public boolean removerEstatisticas (String nome, String torneioId) {
        return estatisticas.removeIf(e -> e.getNomeJogadorOuEquipe().equals(nome)
                && e.getTorneioId().equals(torneioId));
    }
}