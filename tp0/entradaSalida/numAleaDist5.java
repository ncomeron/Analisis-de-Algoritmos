package tp0.entradaSalida;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//Genera un archivo de texto numerosRandom100.txt,
//con numeros aleatorios en un rango del 1 al 1000, sin repetirse entre si.
public class numAleaDist5 {

  static final String NOMBRE_ARCHIVO = "src/tp0/entradaSalida/numerosRandom100.txt";
  static final int arrNum[] = new int[1000];

  private static void generarArchivo() {
    boolean encontrado, sigue;
    int m = 0;
    try {
      BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
      Random generador = new Random();
      // Pusimos que se eligen 50 numeros al azar pero distintos entre si, ya que el
      // enunciado no te lo especifica
      for (int i = 0; i < 50; i++) {

        sigue = true;
        int num = generaNumRandom(generador, 1, 1000);
        while (sigue) {
          encontrado = esNumRepetido(num, arrNum);
          if (!encontrado) {
            sigue = false;

            arrNum[m] = num;
            buff.write(num + "\n");
            System.out.println(num);
            m++;
          }
        }
      }
      buff.close();

    } catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
          + "que queriamos leer no existe.");
    } catch (IOException ex) {
      System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
  }

  private static int generaNumRandom(Random r, int min, int max) {
    return r.nextInt(max - min + 1) + min;
  }

  private static boolean esNumRepetido(int n, int arr[]) {
    boolean estaRep = false;
    int p = 0;
    while (!estaRep && p < arr.length) {
      estaRep = (arr[p] == n);
      p++;
    }
    return estaRep;
  }

  public static void main(String[] args) {
    generarArchivo();
  }
}
