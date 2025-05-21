package Repositorios;

import Modelos.Estatisticas;
import java.util.List;
import java.util.Optional;

/**
 * Interface para um repositório de listas de Estatísticas.
 * Define métodos para adicionar, listar, buscar, atualizar e remover estatísticas.
 */
public interface InterfaceRepoListasEstatiscas {

    /**
     * Adiciona uma estatística ao repositório.
     */
    void adicionar(Estatisticas estatistica);

    /**
     * Lista todas as estatísticas presentes no repositório.
     */
    List<Estatisticas> listarTodos();

    /**
     * Busca estatísticas pelo nome do participante e torneio.
     */
    Optional<Estatisticas> buscarPorNomeETorneio( String nome, String torneioId);

    /**
     * Atualiza uma estatística específica.
     */
    boolean atualizarEstatisticas (Estatisticas estatisticaAtualizada);

    /**
     * Remove uma estatística pelo nome do participante e torneio.
     */
    public boolean removerEstatisticas (String nome, String torneioId);
}