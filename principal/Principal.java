package principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String[] nomesDosNinjas = new String[99];
        int[] indicesDosNinjas = new int[99];
        int indice = 0;
        int totalNinjasCadastrados = 0;

        Scanner entrada = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("----------|CADASTRO DE NINJA|----------");
            System.out.println("1 - Cadastrar Ninja.");
            System.out.println("2 - Listar Ninjas.");
            System.out.println("3 - Deletar Ninja.");
            System.out.println("4 - Sair.");
            System.out.println("---------------------------------------");
            System.out.print("Digite a sua opção desejada: ");
            escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1:
                    do {
                        System.out.print("\nDigite o nome do ninja: ");
                        nomesDosNinjas[indice] = entrada.nextLine();
                    } while (nomesDosNinjas[indice].isEmpty());

                    System.out.printf("\nO Ninja %s foi cadastrado com sucesso.\n\n", nomesDosNinjas[indice]);

                    indicesDosNinjas[indice] = indice;
                    indice++;
                    totalNinjasCadastrados++;

                    break;
                case 2:
                    if (totalNinjasCadastrados == 0) {
                        System.out.println("Não há ninjas cadastrados.");
                    } else {
                        for (int i = 0; i < nomesDosNinjas.length; i++) {
                            if (nomesDosNinjas[i] != null && indicesDosNinjas[i] != -1) {
                                System.out.printf("%d - %s\n", indicesDosNinjas[i]+1, nomesDosNinjas[i]);
                            }
                        }
                    }
                    break;
                case 3:
                    if (totalNinjasCadastrados > 0) {
                        System.out.print("Digite o índice do ninja que deseja deletar: ");
                        int indiceDesejadoParaDeleter = entrada.nextInt();
                        indiceDesejadoParaDeleter--;
                        String ninjaExcluido = "";
                        for (int i = 0; i < nomesDosNinjas.length; i++) {
                            if (indiceDesejadoParaDeleter == indicesDosNinjas[i]) {
                                ninjaExcluido = nomesDosNinjas[indiceDesejadoParaDeleter];
                                nomesDosNinjas[indiceDesejadoParaDeleter] = "";
                                indicesDosNinjas[indiceDesejadoParaDeleter] = -1;
                                totalNinjasCadastrados--;
                                break;
                            }
                        }
                        System.out.printf("\nO ninja %s foi deletado com sucesso.\n", ninjaExcluido);
                    } else {
                        System.out.println("Não há nenhum ninja cadastrado.");
                    }
                    break;

                case 4:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 4);
    }
}
