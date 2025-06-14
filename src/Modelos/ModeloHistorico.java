package Modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ModeloHistorico {
    private String tipoEvento;
    private String nomeJogo;
    private LocalDateTime dataHora;
    private int pontos;
    private List<String> jogadores;
    private int posicaoJogador;

    public ModeloHistorico(String tipoEvento, String nomeJogo, int pontos, List<String> jogadores, int posicaoJogador) {
        if (!tipoEvento.equalsIgnoreCase("VITÓRIA") && !tipoEvento.equalsIgnoreCase("DERROTA")) {
            throw new IllegalArgumentException("O tipo de evento deve ser 'VITÓRIA' ou 'DERROTA'.");
        }
        this.tipoEvento = tipoEvento.toUpperCase();
        this.nomeJogo = nomeJogo;
        this.dataHora = LocalDateTime.now();
        this.pontos = pontos;
        this.jogadores = jogadores;
        this.posicaoJogador = posicaoJogador;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getPontos() {
        return pontos;
    }

    public List<String> getJogadores() {
        return jogadores;
    }

    public int getPosicaoJogador() {
        return posicaoJogador;
    }

    @Override
    public String toString() {
        String jogTxt = jogadores != null && !jogadores.isEmpty() ? String.join(", ", jogadores) : "N/A";
        return String.format("[%s] %s em %s: %d pts, Posição: %d, Jogadores: %s",
                dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                tipoEvento, nomeJogo, pontos, posicaoJogador, jogTxt);
    }
}