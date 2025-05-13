import java.util.List;
import java.util.Scanner;

public class Main {
    private static ControladorEstatisticas controlador = new ControladorEstatisticas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerInteiro("Digite sua opção: ");

            switch (opcao) {
                case 1:
                    registrarPartida();
                    break;
                case 2:
                    exibirRankings();
                    break;
                case 3:
                    consultarEstatisticas();
                    break;
                case 4:
                    listarTorneios();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE ESTATÍSTICAS ESPORTIVAS ===");
        System.out.println("1. Registrar partida");
        System.out.println("2. Exibir rankings");
        System.out.println("3. Consultar estatísticas individuais");
        System.out.println("4. Listar torneios");
        System.out.println("5. Sair");
    }

    private static void registrarPartida() {
        System.out.println("\n=== REGISTRAR PARTIDA ===");
        String torneio = lerString("Nome do torneio: ");
        String participante = lerString("Nome do jogador/equipe: ");
        String resultado = lerString("Resultado (V para vitória, D para derrota): ").toUpperCase();

        if (resultado.equals("V")) {
            controlador.registrarVitoria(participante, torneio);
            System.out.println("Vitória registrada com sucesso!");
        } else if (resultado.equals("D")) {
            controlador.registrarDerrota(participante, torneio);
            System.out.println("Derrota registrada com sucesso!");
        } else {
            System.out.println("Resultado inválido! Use V ou D.");
        }
    }

    private static void exibirRankings() {
        System.out.println("\n=== EXIBIR RANKINGS ===");
        System.out.println("1. Ranking geral");
        System.out.println("2. Ranking por torneio");
        int opcao = lerInteiro("Digite sua opção: ");

        if (opcao == 1) {
            System.out.println("\n" + controlador.exibirRanking());
        } else if (opcao == 2) {
            String torneio = lerString("Nome do torneio: ");
            List<Estatisticas> ranking = controlador.filtrarPorTorneio(torneio);

            if (ranking.isEmpty()) {
                System.out.println("Nenhum resultado encontrado para este torneio.");
            } else {
                ranking.sort((e1, e2) -> Integer.compare(e2.getPontos(), e1.getPontos()));
                System.out.println("\n=== RANKING " + torneio.toUpperCase() + " ===");
                for (int i = 0; i < ranking.size(); i++) {
                    System.out.printf("#%d - %s%n", i+1, ranking.get(i).toString());
                }
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void consultarEstatisticas() {
        System.out.println("\n=== CONSULTAR ESTATÍSTICAS ===");
        String torneio = lerString("Nome do torneio: ");
        String participante = lerString("Nome do jogador/equipe: ");

        Estatisticas stats = controlador.getEstatisticasList().stream()
                .filter(e -> e.getNomeJogadorOuEquipe().equalsIgnoreCase(participante) &&
                        e.getTorneioId().equalsIgnoreCase(torneio))
                .findFirst()
                .orElse(null);

        if (stats == null) {
            System.out.println("Nenhuma estatística encontrada para este participante no torneio especificado.");
        } else {
            System.out.println("\n=== ESTATÍSTICAS DE " + participante.toUpperCase() + " ===");
            System.out.println("Torneio: " + stats.getTorneioId());
            System.out.println("Pontos: " + stats.getPontos() + " (15pts por vitória, 3pts por derrota)");
            System.out.println("Partidas jogadas: " + stats.getPartidasJogadas());
            System.out.println("Vitórias: " + stats.getVitorias());
            System.out.println("Derrotas: " + stats.getDerrotas());
            System.out.printf("Taxa de vitória: %.1f%%%n", stats.calcularTaxaVitoria());
        }
    }

    private static void listarTorneios() {
        System.out.println("\n=== TORNEIOS REGISTRADOS ===");
        controlador.getEstatisticasList().stream()
                .map(Estatisticas::getTorneioId)
                .distinct()
                .forEach(System.out::println);
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }
}