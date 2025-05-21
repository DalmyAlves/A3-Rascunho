package Repositorios;

import Modelos.ControladorEstatisticas;
import java.util.List;
import java.util.Optional;

/**
 * Interface para um repositório de listas de ControladorEstatisticas.
 * Define métodos para adicionar, listar, buscar, atualizar e remover controladores de estatísticas.
 */
public interface InterfaceRepoListasControladoEstatisticas {

    /**
     * Adiciona um novo controlador ao repositório.
     */
    void adicionar( ControladorEstatisticas controlador);

    /**
     * Lista todos os controladores presentes no repositório.
     */
    List<ControladorEstatisticas> listarTodos();

    /**
     * Busca um controlador pelo índice na lista.
     */
    Optional<ControladorEstatisticas> buscarPorIndice( int indice);

    /**
     * Atualiza um controlador pelo índice.
     */
    boolean atualizarPorIndice(int indice, ControladorEstatisticas controladorAtualizado);

    /**
     * Remove um controlador pelo índice.
     */
    boolean removerPorIndice(int indice);

    /**
     * Busca o primeiro controlador da lista, caso exista.
     */
    Optional<ControladorEstatisticas> buscarPrimeiro();

}