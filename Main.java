import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int op = -1;
        while (op != 0) {
            System.out.println("\n#################");
            System.out.println("Jogo 21 Fósforos");
            System.out.println("#################\n");
            System.out.println("O jogo dos 21 fósforos coloca dois oponentes a retirar fósforos, à vez, até sobrar o último.");
            System.out.println("Quem ficar com o último fósforo perde. Em cada jogada é possível retirar 1, 2, 3 ou 4 fósforos.");
            System.out.println("1 - Dois jogadores humanos");
            System.out.println("2 - Humano contra computador (sem inteligência)");
            System.out.println("3 - Humano contra computador (com inteligência)");
            System.out.println("0 - Sair");
            op = in.nextInt();

            switch (op) {
                case 0 -> System.out.println("A sair...");
                case 1 -> DoisJogadores();
                case 2 -> ComputadorFacil();
                case 3 -> ComputadorDificil();
            }
        }
    }

//    1. Dois jogadores humanos;
    private static void DoisJogadores() {
        int vez = rnd.nextInt(1,3);
        System.out.printf("\nO jogador %d joga primeiro.\n", vez);
        int fosforos = 21;
        while(fosforos != 1) {
            System.out.println("Fósforos:\t" + fosforos);
            System.out.println("\n############");
            System.out.println("Jogador " + vez);
            System.out.println("Quantos fósforos quer retirar?");
            int valorJogador = 0;
            try {
                valorJogador = in.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Tipo de dados Errado!");
                in.next();
            }

            if(valorJogador > 0 && valorJogador < 5 && fosforos > valorJogador) {
                fosforos -= valorJogador;
                if(fosforos != 1) {
                    if(vez == 1) {
                        vez+=1;
                    } else {
                        vez-=1;
                    }
                }
            } else {
                System.out.println("Introduza um valor válido (entre 1 e 4).");
            }
        }
        System.out.println("Fósforos:\t" + fosforos);
        System.out.printf("\nParabéns Jogador %d! É o vencedor!\n", vez);
    }

//    2. Humano contra computador (sem inteligência);
    private static void ComputadorFacil() {
        int vez = rnd.nextInt(1,3);
        if(vez == 1) {
            System.out.println("\nO jogador 1 joga primeiro.");
        } else {
            System.out.println("\nO computador joga primeiro");
        }

        int fosforos = 21;
        while(fosforos != 1) {
            System.out.println("Fósforos:\t" + fosforos);
            System.out.println("\n############");
            if(vez == 1) {
                System.out.println("Jogador 1");
                System.out.println("Quantos fósforos quer retirar?");
                int valorJogador = in.nextInt();
                if(valorJogador > 0 && valorJogador < 5 && fosforos > valorJogador) {
                    fosforos -= valorJogador;
                    if(fosforos == 1) {
                        System.out.println("Parabéns Jogador 1! É o vencedor!");
                        break;
                    }

                    System.out.println("Fósforos:\t" + fosforos);
                    System.out.println("\n############");
                    System.out.println("Computador");
                    int valorPC;

                    if(fosforos > 4) {
                        valorPC = rnd.nextInt(1, 5);
                    } else {
                        valorPC = rnd.nextInt(1, fosforos);
                    }
                    System.out.println("Valor jogado: " + valorPC);
                    fosforos -= valorPC;
                    if(fosforos == 1) {
                        System.out.println("Parabéns Computador! É o vencedor!");
                    }
                } else {
                    System.out.println("Introduza um valor válido (entre 1 e 4).");
                }

            } else {
                System.out.println("Computador");
                int valorPC;
                if(fosforos > 4) {
                    valorPC = rnd.nextInt(1, 5);
                } else {
                    valorPC = rnd.nextInt(1, fosforos);
                }
                System.out.println("Valor jogado: " + valorPC);
                fosforos -= valorPC;
                if(fosforos == 1) {
                    System.out.println("Parabéns Computador! É o vencedor!");
                    break;
                }

                System.out.println("Fósforos:\t" + fosforos);
                System.out.println("\n############");
                System.out.println("Jogador 1");
                System.out.println("Quantos fósforos quer retirar?");
                int valorJogador = in.nextInt();
                if(valorJogador > 0 && valorJogador < 5 && fosforos > valorJogador) {
                    fosforos -= valorJogador;
                } else {
                    System.out.println("Introduza um valor válido (entre 1 e 4).");
                    vez = 1;
                }
                if(fosforos == 1) {
                    System.out.println("Parabéns Jogador 1! É o vencedor!");
                }
            }
        }
        System.out.println("Fósforos:\t" + fosforos);
    }

//    3. Humano contra computador (com inteligência);
    private static void ComputadorDificil() {
        int vez = rnd.nextInt(1,3);
        if(vez == 1) {
            System.out.println("\nO jogador 1 joga primeiro.");
        } else {
            System.out.println("\nO computador joga primeiro");
        }
        int fosforos = 21;
        while(fosforos != 1) {
            System.out.println("Fósforos:\t" + fosforos);
            System.out.println("\n############");
            if(vez == 1) {
                System.out.println("Jogador 1");
                System.out.println("Quantos fósforos quer retirar?");
                int valorJogador = in.nextInt();
                if(valorJogador > 0 && valorJogador < 5 && fosforos > valorJogador) {
                    fosforos -= valorJogador;

                    if(fosforos == 1) {
                        System.out.println("Parabéns Jogador 1! É o vencedor!");
                        break;
                    }

                    System.out.println("Fósforos:\t" + fosforos);
                    System.out.println("\n############");
                    System.out.println("Computador");
                    int valorPC;

                    if(fosforos > 4) {
                        // Caso resto de fósforos por 5 for 1 gera valor aleatório. Caso seja 0, joga 4, nas restantes vezes joga o valor de resto - 1
                        if(fosforos % 5 == 1) {
                            valorPC = rnd.nextInt(1, 5);
                        } else if (fosforos % 5 == 0) {
                            valorPC = 4;
                        } else {
                            valorPC = fosforos % 5 - 1;
                        }
                    } else {
                        valorPC = fosforos - 1;
                    }
                    System.out.println("Valor jogado: " + valorPC);
                    fosforos -= valorPC;
                    if(fosforos == 1) {
                        System.out.println("Parabéns Computador! É o vencedor!");
                    }
                } else {
                    System.out.println("Introduza um valor válido (entre 1 e 4).");
                }

            } else {
                System.out.println("Computador");
                int valorPC;
                // Faz a primeira jogada aleatória
                if(fosforos == 21) {
                    valorPC = rnd.nextInt(1, 5);
                    System.out.println("Valor jogado: " + valorPC);
                    fosforos -= valorPC;
                } else if(fosforos > 4) {
                    // Caso resto de fósforos por 5 for 1 gera valor aleatório. Caso seja 0, joga 4, nas restantes vezes joga o valor de resto - 1
                    if(fosforos % 5 == 1) {
                        valorPC = rnd.nextInt(1, 5);
                    } else if (fosforos % 5 == 0) {
                        valorPC = 4;
                    } else {
                        valorPC = fosforos % 5 - 1;
                    }
                    System.out.println("Valor jogado: " + valorPC);
                    fosforos -= valorPC;
                } else {
                    valorPC = fosforos - 1;
                    System.out.println("Valor jogado: " + valorPC);
                    fosforos -= valorPC;
                }
                if(fosforos == 1) {
                    System.out.println("Parabéns Computador! É o vencedor!");
                    break;
                }

                System.out.println("Fósforos:\t" + fosforos);
                System.out.println("\n############");
                System.out.println("Jogador 1");
                System.out.println("Quantos fósforos quer retirar?");
                int valorJogador = in.nextInt();
                if(valorJogador > 0 && valorJogador < 5 && fosforos > valorJogador) {
                    fosforos -= valorJogador;
                } else {
                    System.out.println("Introduza um valor válido (entre 1 e 4).");
                    vez = 1;
                }
                if(fosforos == 1) {
                    System.out.println("Parabéns Jogador 1! É o vencedor!");
                }
            }
        }
    }
}