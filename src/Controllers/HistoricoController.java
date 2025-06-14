package Controllers;

import Modelos.ModeloHistorico;
import Repositorios.Listas.RepoListaHistorico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HistoricoController {

    @FXML private ComboBox<String> cbJogoHistorico;
    @FXML private TableView<ModeloHistorico> tabelaHistorico;
    @FXML private TableColumn<ModeloHistorico, String> colDataHora;
    @FXML private TableColumn<ModeloHistorico, String> colTipoEvento;
    @FXML private TableColumn<ModeloHistorico, Integer> colPontos;
    @FXML private TableColumn<ModeloHistorico, String> colJogadores;
    @FXML private TableColumn<ModeloHistorico, Integer> colPosicao;
    @FXML private TableColumn<ModeloHistorico, String> colJogo;
    @FXML private Label lblUltimaAtualizacaoHistorico;

    private RepoListaHistorico repoHistorico = new RepoListaHistorico();

    @FXML
    public void initialize() {
        // Dados Simulados para o Histórico
        repoHistorico.adicionar(new ModeloHistorico("VITÓRIA", "League of Legends", 15, Arrays.asList("Jogador A", "Aliado 1", "Aliado 2", "Aliado 3"), 1));
        repoHistorico.adicionar(new ModeloHistorico("DERROTA", "Counter-Strike", -5, Arrays.asList("Jogador B", "Aliado 3", "Adversário 1"), 2));
        repoHistorico.adicionar(new ModeloHistorico("VITÓRIA", "Valorant", 10, Arrays.asList("Jogador C", "Aliado 4"), 1));
        repoHistorico.adicionar(new ModeloHistorico("VITÓRIA", "League of Legends", 12, Arrays.asList("Jogador A", "Aliado 1", "Aliado 2"), 1));
        repoHistorico.adicionar(new ModeloHistorico("DERROTA", "Dota 2", -8, Arrays.asList("Jogador D", "Adversário 2"), 5));
        repoHistorico.adicionar(new ModeloHistorico("VITÓRIA", "Counter-Strike", 20, Arrays.asList("Jogador B", "Aliado 3"), 1));
        repoHistorico.adicionar(new ModeloHistorico("DERROTA", "Valorant", -10, Arrays.asList("Jogador C", "Adversário 4"), 3));

        ObservableList<String> jogos = repoHistorico.listarTodos().stream()
                .map(ModeloHistorico::getNomeJogo)
                .distinct()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        cbJogoHistorico.setItems(jogos);

        colDataHora.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                cell.getValue().getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        ));
        colTipoEvento.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTipoEvento()));
        colPontos.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getPontos()).asObject());
        colJogadores.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                String.join(", ", cell.getValue().getJogadores())
        ));
        colPosicao.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getPosicaoJogador()).asObject());
        colJogo.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNomeJogo()));

        tabelaHistorico.setItems(FXCollections.observableArrayList(repoHistorico.listarTodos()));
        atualizarUltimaAtualizacao();
    }

    @FXML
    public void aplicarFiltroHistorico() {
        String jogoSelecionado = cbJogoHistorico.getValue();

        List<ModeloHistorico> listaFiltrada;
        if (jogoSelecionado == null || jogoSelecionado.isEmpty()) {
            listaFiltrada = repoHistorico.listarTodos();
        } else {
            listaFiltrada = repoHistorico.filtrarPorJogo(jogoSelecionado);
        }
        tabelaHistorico.setItems(FXCollections.observableArrayList(listaFiltrada));
        atualizarUltimaAtualizacao();
    }

    private void atualizarUltimaAtualizacao() {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        lblUltimaAtualizacaoHistorico.setText("Última atualização: " + dataHora);
    }
}