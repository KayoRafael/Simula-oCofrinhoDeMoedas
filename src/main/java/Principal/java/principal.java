package Principal.java;

import java.util.ArrayList;
import java.util.Scanner;

// Classe abstrata que representa uma moeda genérica
abstract class Moeda {
    protected double valor; // Valor da moeda

    // Construtor da classe Moeda
    public Moeda(double valor) {
        this.valor = valor;
    }

    // Método abstrato para obter o nome da moeda
    public abstract String getNome();

    // Método para obter o valor da moeda
    public double getValor() {
        return valor;
    }
}

// Classes concretas que representam moedas específicas
class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String getNome() {
        return "Dólar";
    }
}

class Euro extends Moeda {
    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String getNome() {
        return "Euro";
    }
}

class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }

    @Override
    public String getNome() {
        return "Real";
    }
}

// Classe que representa o cofrinho, contendo uma coleção de moedas
class Cofrinho {
    private ArrayList<Moeda> moedas; // Coleção de moedas

    // Construtor da classe Cofrinho
    public Cofrinho() {
        moedas = new ArrayList<>(); // Inicializa a coleção de moedas
    }

    // Método para adicionar uma moeda ao cofrinho
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
    }

    // Método para remover uma moeda específica do cofrinho
    public void removerMoeda(int indice) {
        moedas.remove(indice);
    }

    // Método para listar todas as moedas no cofrinho
    public void listarMoedas() {
        for (int i = 0; i < moedas.size(); i++) {
            Moeda moeda = moedas.get(i);
            System.out.println((i + 1) + ". " + moeda.getNome() + ": " + moeda.getValor());
        }
    }

    // Método para calcular o total em reais de todas as moedas no cofrinho
    public double calcularTotalEmReais() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.getValor();
        }
        return total;
    }
}

// Classe principal que contém o menu e interage com o usuário
public class principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para entrada do usuário
        Cofrinho cofrinho = new Cofrinho(); // Instância do cofrinho

        int opcao;
        // Loop principal do menu
        do {
            // Exibe o menu
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular total em reais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê a opção do usuário
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1: // Adicionar moeda
                    System.out.print("Informe o valor da moeda: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do teclado
                    System.out.print("Informe o tipo da moeda (Dolar/Euro/Real): ");
                    String tipo = scanner.nextLine();
                    Moeda moeda;
                    switch (tipo.toLowerCase()) {
                        case "dolar":
                            moeda = new Dolar(valor);
                            break;
                        case "euro":
                            moeda = new Euro(valor);
                            break;
                        case "real":
                            moeda = new Real(valor);
                            break;
                        default:
                            System.out.println("Tipo de moeda inválido.");
                            continue;
                    }
                    cofrinho.adicionarMoeda(moeda); // Adiciona a moeda ao cofrinho
                    System.out.println("Moeda adicionada com sucesso.");
                    break;
                case 2: // Remover moeda
                    System.out.print("Informe o índice da moeda a ser removida: ");
                    int indice = scanner.nextInt();
                    cofrinho.removerMoeda(indice - 1); // Remove a moeda do cofrinho
                    System.out.println("Moeda removida com sucesso.");
                    break;
                case 3: // Listar moedas
                    System.out.println("Moedas no cofrinho:");
                    cofrinho.listarMoedas(); // Lista as moedas no cofrinho
                    break;
                case 4: // Calcular total em reais
                    System.out.println("Total em reais: R$" + cofrinho.calcularTotalEmReais());
                    break;
                case 0: // Sair
                    System.out.println("Saindo...");
                    break;
                default: // Opção inválida
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0); // Repete até que o usuário escolha sair

        scanner.close(); // Fecha o scanner
    }
}
