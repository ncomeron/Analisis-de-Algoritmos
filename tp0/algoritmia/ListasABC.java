package tp0.algoritmia;

import tp0.algoritmia.algoritmosOrdenamiento.Mergesort;
import tp0.algoritmia.algoritmosOrdenamiento.Quicksort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ListasABC {

  static final int CANT_NUMEROS_A = 100;
  static final int CANT_NUMEROS_B = 60;
  static final int MAX_VALOR = 999;
  // listaA y listaB son generados y luego leidos, mientras que listaC, es la
  // salida final (union de ambas listas ordenadas).
  static final String NOMBRE_ARCHIVO_A = "src/tp0/algoritmia/listaA.txt";
  static final String NOMBRE_ARCHIVO_B = "src/tp0/algoritmia/listaB.txt";
  static final String NOMBRE_ARCHIVO_C = "src/tp0/algoritmia/listaC.txt";

  public static void main(String[] args) {

    // Se generan ambas listas de numeros (se pueden comentar una vez generados).
    generarArchivo(CANT_NUMEROS_A, MAX_VALOR, NOMBRE_ARCHIVO_A);
    generarArchivo(CANT_NUMEROS_B, MAX_VALOR, NOMBRE_ARCHIVO_B);

    // Se realizan ambas lecturas de datos.
    int[] a = leerArchivo(CANT_NUMEROS_A, NOMBRE_ARCHIVO_A);
    int[] b = leerArchivo(CANT_NUMEROS_B, NOMBRE_ARCHIVO_B);
    int[] c = new int[CANT_NUMEROS_A + CANT_NUMEROS_B];

    // Muestra por pantalla A SIN ordenar.
    System.out.println("A sin ordenar: ");
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println("\n----------------------------------------------------------");

    // Ordena A mediante el algoritmo Quicksort.
    Quicksort.quicksort(a, 0, a.length - 1);

    // Muestra por pantalla A ORDENADO.
    System.out.println("A ordenado: ");
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
      c[i] = a[i]; // Mientras mostramos A ORDENADO por pantalla, va llenando C con los elementos
                   // de A.
    }
    System.out.println("\n----------------------------------------------------------");

    // Muestra por pantalla B SIN ordenar.
    System.out.println("B sin ordenar: ");
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " ");
    }
    System.out.println("\n----------------------------------------------------------");

    // Ordena B mediante el algoritmo Mergesort.
    Mergesort.mergesort(b, 0, b.length - 1);

    // Muestra por pantalla B ORDENADO.
    System.out.println("B ordenado: ");
    int n = a.length; // Esta variable es el indice por donde continua el llenado de C, tras finalizar
                      // con A.
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " ");
      c[n] = b[i]; // Al igual que con A, va llenando C con los elementos ORDENADOS de B.
      n++; // Se incrementa el indice desde donde habia finalizado anteriormente.
    }
    System.out.println("\n----------------------------------------------------------");

    // Muestra por pantalla C SIN ordenar.
    System.out.println("C sin ordenar: ");
    for (int i = 0; i < c.length; i++) {
      System.out.print(c[i] + " ");
    }
    System.out.println("\n----------------------------------------------------------");

    // Ordena C (compuesto por A y B que fueron previamente ordenadas) mediante el
    // algoritmo Mergesort.
    Mergesort.mergesort(c, 0, c.length - 1);

    // Muestra por pantalla C ORDENADO, y a su vez, escribe en la listaC.
    try {
      BufferedWriter bufferC = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_C));
      System.out.println("C ordenado: ");
      for (int i = 0; i < c.length; i++) {
        System.out.print(c[i] + " ");
        bufferC.write(c[i] + "\n");
      }
      bufferC.close();
    } catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
          + "que queriamos leer no existe.");
    } catch (IOException ex) {
      System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
  }

  // INICIO Generacion y Lectura de ambas listas.
  private static void generarArchivo(final int CANT_NUMEROS, final int MAX_VALOR, final String NOMBRE_ARCHIVO) {
    try {
      BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
      Random generador = new Random();
      for (int i = 0; i < CANT_NUMEROS; i++) {
        int num = generador.nextInt(MAX_VALOR);
        buff.write(num + "\n");
        // System.out.println(num);
      }
      buff.close();
    } catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
          + "que queriamos leer no existe.");
    } catch (IOException ex) {
      System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
  }

  private static int[] leerArchivo(final int CANT_NUMEROS, final String NOMBRE_ARCHIVO) {
    int[] arreglo = new int[CANT_NUMEROS];
    try {
      BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
      for (int i = 0; i < CANT_NUMEROS; i++) {
        arreglo[i] = Integer.parseInt(buff.readLine());
      }
      buff.close();
    } catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
          + "que queriamos leer no existe.");
    } catch (IOException ex) {
      System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
    return arreglo;
  }
  // FIN Generacion y Lectura de ambas listas.
}
