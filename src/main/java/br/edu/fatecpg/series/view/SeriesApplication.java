package br.edu.fatecpg.series.view;

import br.edu.fatecpg.series.model.Serie;
import br.edu.fatecpg.series.service.ConsomeApi;
import br.edu.fatecpg.series.service.ConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class SeriesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);

	 boolean i = true;

		while (i) {
			System.out.println("Digite uma opção" + "\n" +
					"1 - Buscar Dados de Filme ou Série" + " \n" +
					"2 - Fechar App");

			int opc = scan.nextInt();
			scan.nextLine();//senao pega um espaço

			switch (opc) {
				case 1:

					System.out.println("Digite o nome do filme ou série:");
					String filme = scan.nextLine();
					if (filme!=null) {
						ConverteDado conversor = new ConverteDado();
						String json = ConsomeApi.obterDados(filme);
						Serie serie = conversor.obterDado(json, Serie.class);
						System.out.println(serie);
					};
					break;

				case 2:
					i=false;
					break;

			}
		}


	}
}
