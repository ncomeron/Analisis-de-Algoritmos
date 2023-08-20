package tp0.entradaSalida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class genera100Alea3 {

  // Genera un archivo de texto numeros.txt con valores numericos de tipo
  // double en un rango de -100 y 100, elegidos aleatoriamente.
  static final String NOMBRE_ARCHIVO = "src/tp0/entradaSalida/numeros.txt";

  private static void generarArchivo() {
    try {
      BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
      Random generador = new Random();
      for (int i = 0; i < 100; i++) {
        double num = generaNumRandom(generador, -100, 100);
        buff.write(num + "\n");
        System.out.println(num);
      }
      buff.close();

    } catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
          + "que queriamos leer no existe.");
    } catch (IOException ex) {
      System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
  }

  private static double generaNumRandom(Random r, double min, double max) {
    return min + (max - min) * r.nextDouble();
  }

  public static void main(String[] args) {
    generarArchivo();
}
}
