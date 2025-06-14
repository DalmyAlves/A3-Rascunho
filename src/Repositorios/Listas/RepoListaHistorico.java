package Repositorios.Listas;

import Modelos.ModeloHistorico;
import Repositorios.InterfaceRepoListaHistorico;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepoListaHistorico implements InterfaceRepoListaHistorico {
    private final List<ModeloHistorico> historico = new ArrayList<>();

    @Override
    public void adicionar(ModeloHistorico evento) {
        if (evento != null) {
            historico.add(evento);
        }
    }

    @Override
    public List<ModeloHistorico> listarTodos() {
        return new ArrayList<>(historico);
    }

    @Override
    public Optional<ModeloHistorico> buscarPorIndice(int indice) {
        if (indice >= 0 && indice < historico.size()) {
            return Optional.of(historico.get(indice));
        }
        return Optional.empty();
    }

    @Override
    public List<ModeloHistorico> filtrarPorJogo(String nomeJogo) {
        if (nomeJogo == null || nomeJogo.trim().isEmpty()) {
            return listarTodos();
        }
        return historico.stream()
                .filter(e -> e.getNomeJogo().equalsIgnoreCase(nomeJogo))
                .collect(Collectors.toList());
    }

    @Override
    public boolean atualizarPorIndice(int indice, ModeloHistorico eventoAtualizado) {
        boolean retornoAtualizar = false;
        if (indice >= 0 && indice < historico.size() && eventoAtualizado != null) {
            historico.set(indice, eventoAtualizado);
            retornoAtualizar = true;
        }
        return retornoAtualizar;
    }

    @Override
    public boolean removerPorIndice(int indice) {
        boolean retornoRemove = false;
        if (indice >= 0 && indice < historico.size()) {
            historico.remove(indice);
            retornoRemove = true;
        }
        return retornoRemove;
    }

    @Override
    public boolean removerPorJogo(String nomeJogo) {
        if (nomeJogo == null || nomeJogo.trim().isEmpty()) {
            return false;
        }
        return historico.removeIf(e -> e.getNomeJogo().equalsIgnoreCase(nomeJogo)); 
    }

    @Override
    public Optional<ModeloHistorico> buscarPrimeiro() {
        if (historico.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(historico.get(0));
    }
}