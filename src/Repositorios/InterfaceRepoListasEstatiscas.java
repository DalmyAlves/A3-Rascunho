package Repositorios;

import Modelos.ModeloEstatisticas;
import java.util.List;
import java.util.Optional;

/**
 * Interface unificada para repositório de Estatísticas e Controladores de Estatísticas.
 * Define métodos para adicionar, listar, buscar, atualizar e remover dados.
 */
public interface InterfaceRepoListasEstatiscas {

    // ---------- Métodos da InterfaceRepoListasEstatiscas ----------

    /**
     * Adiciona uma estatística ao repositório.
     */
    void adicionar(ModeloEstatisticas estatistica);

    /**
     * Lista todas as estatísticas presentes no repositório.
     */
    List<ModeloEstatisticas> listarTodos();

    /**
     * Busca estatísticas pelo nome do participante e torneio.
     */
    Optional<ModeloEstatisticas> buscarPorNomeETorneio(String nome, String torneioId);

    /**
     * Atualiza uma estatística específica.
     */
    boolean atualizarEstatisticas(ModeloEstatisticas estatisticaAtualizada);

    /**
     * Remove uma estatística pelo nome do participante e torneio.
     */
    boolean removerEstatisticas(String nome, String torneioId);

    // Métodos da Interface do antigo arquivo InterfaceRepoListasControladoEstatisticas

    /**
     * Busca um controlador pelo índice na lista.
     */
    Optional<ModeloEstatisticas> buscarPorIndice(int indice);

    /**
     * Atualiza um controlador pelo índice.
     */
    boolean atualizarPorIndice(int indice, ModeloEstatisticas controladorAtualizado);

    /**
     * Remove um controlador pelo índice.
     */
    boolean removerPorIndice(int indice);

    /**
     * Busca o primeiro controlador da lista, caso exista.
     */
    Optional<ModeloEstatisticas> buscarPrimeiro();
}
