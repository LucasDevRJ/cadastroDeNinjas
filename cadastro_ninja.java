// NOTA: caso `scanner.nextInt` receba um valor
// diferente de um inteiro, o mesmo causará
// um ERRO FATAL, assim finalizando o programa.

import java.util.Scanner;

public class cadastro_ninja {
	public static void main(String[] args) {

		String[] lista_de_ninjas = new String[99];
		Scanner entrada = new Scanner(System.in);

		int total_de_ninjas = 0;
		int escolha = 0;


		do {
			System.out.println("\n+--------[ CADASTRO DE NINJA ]--------+");
			System.out.println("| 1 - Cadastrar ninja                 |");
			System.out.println("| 2 - Listar ninjas                   |");
			System.out.println("| 3 - Deletar ninja                   |");
			System.out.println("| 4 - Sair                            |");
			System.out.println("+-------------------------------------+");

			System.out.print("Digite um dos índices: ");
			escolha = entrada.nextInt();
			entrada.nextLine(); // limpa a quebra de linha no "buffer"


			switch(escolha){
				// cadastrar
				case 1:
					if(total_de_ninjas == 99){
						System.out.println("O limite de ninjas foi atingido!");
						break;
					}

					System.out.print("Digite o nome do ninja: ");
					while(true){
						lista_de_ninjas[ total_de_ninjas ] = entrada.nextLine();

						if(!lista_de_ninjas[ total_de_ninjas ].isEmpty()){
							break;
						}
						System.out.print("Nome inválido! Tente novamente: ");
					}

					// `total_de_ninjas` é atualizado a frente ->
					System.out.printf("O ninja '%s' foi cadastrado com sucesso (%d/99).\n", lista_de_ninjas[ total_de_ninjas ], ++total_de_ninjas);
					break;

				// listar
				case 2:
					if(total_de_ninjas == 0){
						System.out.println("Não há ninjas cadastrados.");
						break;
					}

					System.out.println("Ninjas cadastrados:");

					// imprime apenas os itens diferentes de `null`
					for(byte i = 0; i < total_de_ninjas; i++){
						System.out.printf("%d - %s\n", i + 1, lista_de_ninjas[i]);
					}
					break;

				// deletar
				case 3:
					if(total_de_ninjas == 0){
						System.out.println("Não há nenhum ninja cadastrado.");
						break;
					}

					System.out.printf("Digite o índice do ninja que deseja deletar (entre 1-%d): ", total_de_ninjas);
					int para_deletar = entrada.nextInt() - 1;
					entrada.nextLine(); // limpa a quebra de linha no "buffer"

					if(para_deletar >= total_de_ninjas){
						System.out.println("O valor especificado é inválido!");
						break;
					}

					Boolean foi_deletado = false;
					String ninja_deletado = lista_de_ninjas[ para_deletar ];

					for(byte i = 0; i < total_de_ninjas; i++){
						if(!foi_deletado){
							if(lista_de_ninjas[i] == lista_de_ninjas[ para_deletar ]){
								foi_deletado = true;
								lista_de_ninjas[i] = null;
							}
							continue;
						}

						// move as Strings a frente para trás, assim
						// preenchendo o novo espaço vazio
						lista_de_ninjas[i - 1] = lista_de_ninjas[i];
						lista_de_ninjas[i] = null;
					}

					total_de_ninjas--;
					System.out.printf("O ninja '%s' foi deletado com sucesso (%d/99).\n", ninja_deletado, total_de_ninjas);
					break;

				// sair
				case 4:
					System.out.println("Programa finalizado com sucesso.\n");
					break;

				// esolha inválida
				default:
					System.out.println("Opção inválida!");
			}
		}while(escolha != 4);

		entrada.close();
	}
}
