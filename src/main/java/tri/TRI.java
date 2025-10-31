package tri;

import java.util.Scanner;

public class TRI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem vindo ao programa TRI!");
		Integer[] lados = {0,0,0};
		for(int i = 0; i < 3; i++) {
			System.out.println("Digite o lado" + i + " do triângulo");
			lados[i] = scanner.nextInt();	
		}		
		tipoTriangulo(lados);
	}
	
	public static String tipoTriangulo(Integer[] lados) {
		if(lados.length > 3 || lados.length < 3) {
			throw new IllegalArgumentException("Quantidade de lados inválida");
		}
		for(int i = 0; i < 3; i++) {
			int n1 = (i + 1) % 3;
			int n2 = (i + 2) % 3;
			if(lados[i] >= lados[n1] + lados[n2]) {
				throw new IllegalArgumentException("Lado " + (i + 1) +  " maior que a soma dos demais lados do triângulo");
			}
		}
		for(int i = 0; i < 3; i++) {
			int n1 = (i + 1) % 3;
			int n2 = (i + 2) % 3;
			if(lados[i] == lados[n1] && lados[i] == lados[n2]) {
				return "Equilátero";
			}
			else if(lados[i] == lados[n1] || lados[i] == lados[n2]) {
				return "Isósceles";
			}
		}
		
		return "Escaleno";
	}

}
