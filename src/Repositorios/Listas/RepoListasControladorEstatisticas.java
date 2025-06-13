package Repositorios.Listas;

import Modelos.ModeloEstatisticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação de um repositório de listas para objetos ControladorEstatisticas usando ArrayList.
 * Permite adicionar, listar, buscar, atualizar e remover controladores de estatísticas.
 */
public class RepoListasControladorEstatisticas {
    private List<ModeloEstatisticas> controladores = new ArrayList<>();

    /**
     * Adiciona um novo controlador ao repositório.
     * @param controlador o controlador de estatísticas a ser adicionado
     */
    public void adicionar(ModeloEstatisticas controlador) {
        controladores.add(controlador);
    }

    /**
     * Lista todos os controladores presentes no repositório.
     * @return uma nova lista contendo todos os controladores
     */
    public List<ModeloEstatisticas> listarTodos() {
        return new ArrayList<>(controladores);
    }

    /**
     * Busca um controlador pelo índice na lista.
     * @param indice o índice do controlador
     * @return um Optional contendo o controlador, se encontrado
     */
    public Optional<ModeloEstatisticas> buscarPorIndice(int indice) {
        try {
            return Optional.of(controladores.get(indice));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    /**
     * Atualiza um controlador pelo índice.
     * @param indice o índice do controlador a ser atualizado
     * @param controladorAtualizado o novo controlador
     * @return true se a atualização foi bem-sucedida, false caso contrário
     */
    public boolean atualizarPorIndice(int indice, ModeloEstatisticas controladorAtualizado) {
        boolean retorno;
        try {
            controladores.set(indice, controladorAtualizado);
            retorno = true;
        } catch (IndexOutOfBoundsException e) {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Remove um controlador pelo índice.
     * @param indice o índice do controlador a ser removido
     * @return true se a remoção foi bem-sucedida, false caso contrário
     */
    public boolean removerPorIndice(int indice) {
        boolean retorno;
        try {
            controladores.remove(indice);
            retorno = true;
        } catch (IndexOutOfBoundsException e) {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Busca o primeiro controlador da lista, caso exista.
     * @return um Optional contendo o primeiro controlador, se existir
     */
    public Optional<ModeloEstatisticas> buscarPrimeiro() {
        if (controladores.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(controladores.get(0));
     }
}