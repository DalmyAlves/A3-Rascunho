package Repositorios.Listas;

import Modelos.ModeloEstatisticas;
import Repositorios.InterfaceRepoListasEstatiscas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação do repositório de estatísticas usando listas.
 * Permite adicionar, listar, buscar, atualizar e remover estatísticas de participantes em torneios.
 */
public class RepoListaEstatisticas implements InterfaceRepoListasEstatiscas {

    private final List<ModeloEstatisticas> estatisticas = new ArrayList<>();

    /**
     * Adiciona uma estatística ao repositório.
     * @param estatistica a estatística a ser adicionada
     */
    @Override
    public void adicionar(ModeloEstatisticas estatistica) {
        estatisticas.add(estatistica);
    }

    /**
     * Lista todas as estatísticas presentes no repositório.
     * @return uma nova lista contendo todas as estatísticas
     */
    @Override
    public List<ModeloEstatisticas> listarTodos() {
        return new ArrayList<>(estatisticas);
    }

    /**
     * Busca estatísticas pelo nome do participante e torneio.
     * @param nome nome do participante
     * @param torneioId identificador do torneio
     * @return um Optional contendo a estatística, se encontrada
     */
    @Override
    public Optional<ModeloEstatisticas> buscarPorNomeETorneio(String nome, String torneioId) {
        return estatisticas.stream()
                .filter(e -> e.getNomeJogadorOuEquipe().equals(nome)
                        && e.getNomeTorneio().equals(torneioId))
                .findFirst();
    }

    /**
     * Atualiza uma estatística específica.
     * @param estatisticaAtualizada a estatística atualizada
     * @return true se a atualização foi bem-sucedida, false caso contrário
     */
    @Override
    public boolean atualizarEstatisticas(ModeloEstatisticas estatisticaAtualizada) {
        for (int i = 0; i < estatisticas.size(); i++) {
            ModeloEstatisticas e = estatisticas.get(i);
            if (e.getNomeJogadorOuEquipe().equals(estatisticaAtualizada.getNomeJogadorOuEquipe())
                    && e.getNomeTorneio().equals(estatisticaAtualizada.getNomeTorneio())) {
                estatisticas.set(i, estatisticaAtualizada);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove uma estatística pelo nome do participante e torneio.
     * @param nome nome do participante
     * @param torneioId identificador do torneio
     * @return true se a remoção foi bem-sucedida, false caso contrário
     */
    @Override
    public boolean removerEstatisticas(String nome, String torneioId) {
        return estatisticas.removeIf(e -> e.getNomeJogadorOuEquipe().equals(nome)
                && e.getNomeTorneio().equals(torneioId));
    }

    /**
     * Busca uma estatística pelo índice na lista.
     * @param indice o índice da estatística
     * @return um Optional contendo a estatística, se encontrada
     */
    @Override
    public Optional<ModeloEstatisticas> buscarPorIndice(int indice) {
        if (indice >= 0 && indice < estatisticas.size()) {
            return Optional.of(estatisticas.get(indice));
        }
        return Optional.empty();
    }

    /**
     * Atualiza uma estatística pelo índice.
     * @param indice o índice da estatística a ser atualizada
     * @param controladorAtualizado a nova estatística
     * @return true se a atualização foi bem-sucedida, false caso contrário
     */
    @Override
    public boolean atualizarPorIndice(int indice, ModeloEstatisticas controladorAtualizado) {
        if (indice >= 0 && indice < estatisticas.size()) {
            estatisticas.set(indice, controladorAtualizado);
            return true;
        }
        return false;
    }

    /**
     * Remove uma estatística pelo índice.
     * @param indice o índice da estatística a ser removida
     * @return true se a remoção foi bem-sucedida, false caso contrário
     */
    @Override
    public boolean removerPorIndice(int indice) {
        if (indice >= 0 && indice < estatisticas.size()) {
            estatisticas.remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Busca a primeira estatística da lista, caso exista.
     * @return um Optional contendo a primeira estatística, se existir
     */
    @Override
    public Optional<ModeloEstatisticas> buscarPrimeiro() {
        if (estatisticas.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(estatisticas.get(0));
    }
}