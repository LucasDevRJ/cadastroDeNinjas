package principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String[] nomesDosNinjas = new String[99];
        int indice = 0;

        Scanner entrada = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("----------|CADASTRO DE NINJA|----------");
            System.out.println("1 - Cadastrar Ninja.");
            System.out.println("2 - Listar Ninjas.");
            System.out.println("3 - Sair.");
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
                    indice++;
                    break;
                case 2:
                    if (indice == 0) {
                        System.out.println("Não há ninjas cadastrados.");
                    } else {
                        for (int i = 0; i < nomesDosNinjas.length; i++) {
                            if (nomesDosNinjas[i] != null) {
                                System.out.printf("%d - %s\n", (i+1), nomesDosNinjas[i]);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Programa finalizado.");
                    break;
            }
        } while (escolha != 3);
    }
}
