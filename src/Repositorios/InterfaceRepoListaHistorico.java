package Repositorios;

import Modelos.ModeloHistorico;
import java.util.List;
import java.util.Optional;


public interface InterfaceRepoListaHistorico {

    void adicionar(ModeloHistorico evento);

    List<ModeloHistorico> listarTodos();

    Optional<ModeloHistorico> buscarPorIndice(int indice);

    List<ModeloHistorico> filtrarPorJogo(String nomeJogo);

    boolean atualizarPorIndice(int indice, ModeloHistorico eventoAtualizado);

    boolean removerPorIndice(int indice);

    boolean removerPorJogo(String nomeJogo);

    Optional<ModeloHistorico> buscarPrimeiro();
}