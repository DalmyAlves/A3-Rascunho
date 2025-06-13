package Repositorios;

import Modelos.ModeloEstatisticas;

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
    void adicionar( ModeloEstatisticas controlador);

    /**
     * Lista todos os controladores presentes no repositório.
     */
    List<ModeloEstatisticas> listarTodos();

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