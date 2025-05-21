package Repositorios;

import Modelos.ControladorEstatisticas;

import java.util.List;
import java.util.Optional;

public interface InterfaceRepoListasControladoEstatisticas {

    void adicionar( ControladorEstatisticas controlador);
    List<ControladorEstatisticas> listarTodos();
    Optional<ControladorEstatisticas> buscarPorIndice( int indice);
    boolean atualizarPorIndice(int indice, ControladorEstatisticas controladorAtualizado);
    boolean removerPorIndice(int indice);
    Optional<ControladorEstatisticas> buscarPrimeiro();

}
