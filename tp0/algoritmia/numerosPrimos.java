package tp0.algoritmia;

import java.util.Scanner;

public class numerosPrimos {

  //Dado un numero ingresado por el usuario, retorna la cantidad de numeros primos entre 2 y n.
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese un numero: ");
    int n = sc.nextInt();
    while (n < 2)
      n = sc.nextInt();

    boolean esPrimo;
    int cantPrimos = 0;

    for (int i = 2; i <= n; i++) {
      esPrimo = esNumeroPrimo(i);
      if (esPrimo)
        cantPrimos++;
    }

    System.out.println("Existen " + cantPrimos + " numeros primos entre 1 y " + n);
  }

  private static boolean esNumeroPrimo(int n) {
    boolean esNumeroPrimo = true;
    int i = 2;

    while (esNumeroPrimo && (i != n)) {
      if ((n % i) == 0)
        esNumeroPrimo = false;
      i++;
    }
    return esNumeroPrimo;
  }
}
