package Controllers;

import Modelos.ModeloEstatisticas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controlador da interface gráfica JavaFX responsável por exibir e filtrar estatísticas de torneios.
 */
public class EstatisticasController {

    @FXML private ComboBox<String> cbTorneio;
    @FXML private Button btnAplicar;
    @FXML private TableView<ModeloEstatisticas> tabela;
    @FXML private TableColumn<ModeloEstatisticas, String> colNome;
    @FXML private TableColumn<ModeloEstatisticas, Integer> colJogos;
    @FXML private TableColumn<ModeloEstatisticas, Integer> colVitorias;
    @FXML private TableColumn<ModeloEstatisticas, Integer> colDerrotas;
    @FXML private TableColumn<ModeloEstatisticas, Integer> colPontos;
    @FXML private TableColumn<ModeloEstatisticas, Integer> colRanking;
    @FXML private Label lblUltimaAtualizacao;

    private ModeloEstatisticas controlador = new ModeloEstatisticas();

    /**
     * Inicializa a interface, popula dados simulados e configura os componentes da tabela.
     */
    @FXML
    public void initialize() {
        // Dados simulados para teste
        controlador.registrarVitoria("Time Alpha", "Torneio 1");
        controlador.registrarDerrota("Time Alpha", "Torneio 1");
        controlador.registrarVitoria("Time Beta", "Torneio 1");
        controlador.registrarDerrota("Time Beta", "Torneio 1");
        controlador.registrarVitoria("Jogador X", "Torneio 2");
        controlador.registrarDerrota("Jogador X", "Torneio 2");

        controlador.atualizarRanking();

        ObservableList<String> torneios = FXCollections.observableArrayList();
        for (ModeloEstatisticas e : controlador.getEstatisticasList()) {
            if (!torneios.contains(e.getNomeTorneio())) {
                torneios.add(e.getNomeTorneio());
            }
        }
        cbTorneio.setItems(torneios);

        colNome.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNomeJogadorOuEquipe()));
        colJogos.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getPartidasJogadas()).asObject());
        colVitorias.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getVitorias()).asObject());
        colDerrotas.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getDerrotas()).asObject());
        colPontos.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getPontos()).asObject());
        colRanking.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getRanking()).asObject());

        atualizarUltimaAtualizacao();
    }

    /**
     * Aplica o filtro de torneio selecionado e atualiza a tabela de estatísticas.
     */
    @FXML
    public void aplicarFiltro() {
        String torneioSelecionado = cbTorneio.getValue();

        if (torneioSelecionado == null || torneioSelecionado.isEmpty()) {
            tabela.setItems(FXCollections.observableArrayList());
            return;
        }

        List<ModeloEstatisticas> listaFiltrada = controlador.filtrarPorTorneio(torneioSelecionado);
        tabela.setItems(FXCollections.observableArrayList(listaFiltrada));
        atualizarUltimaAtualizacao();
    }

    /**
     * Atualiza o rótulo com a data e hora da última atualização.
     */
    private void atualizarUltimaAtualizacao() {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        lblUltimaAtualizacao.setText("Última atualização: " + dataHora);
    }
}