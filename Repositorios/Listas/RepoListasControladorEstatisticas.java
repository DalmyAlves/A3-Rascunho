package Repositorios.Listas;

import Modelos.ControladorEstatisticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepoListasControladorEstatisticas {
    private List<ControladorEstatisticas> controladores = new ArrayList<> ();

    public void adicionar(ControladorEstatisticas controlador) {
        controladores.add(controlador);
    }

    public List<ControladorEstatisticas> listarTodos() {
        return new ArrayList<>(controladores);
    }

    public Optional<ControladorEstatisticas> buscarPorIndice(int indice) {
        try {
            return Optional.of(controladores.get(indice));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public boolean atualizarPorIndice(int indice, ControladorEstatisticas controladorAtualizado) {
        boolean retorno;
        try {
            controladores.set(indice, controladorAtualizado);
            retorno = true;
        } catch (IndexOutOfBoundsException e) {
            retorno = false;
        }
        return retorno;
    }

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

    public Optional<ControladorEstatisticas> buscarPrimeiro() {
        if (controladores.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(controladores.get(0));
    }
}

