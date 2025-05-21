package Repositorios;

import Modelos.Estatisticas;

import java.util.List;
import java.util.Optional;

public interface InterfaceRepoListasEstatiscas {
    void adicionar(Estatisticas estatistica);
    List<Estatisticas> listarTodos();
    Optional<Estatisticas> buscarPorNomeETorneio( String nome, String torneioId);
    boolean atualizarEstatisticas (Estatisticas estatisticaAtualizada);
    public boolean removerEstatisticas (String nome, String torneioId);
}
