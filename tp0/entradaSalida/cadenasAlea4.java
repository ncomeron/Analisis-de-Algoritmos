package tp0.entradaSalida;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class cadenasAlea4 {
  static final String NOMBRE_ARCHIVO = "src/entradaSalida/cadenasAleatorias.txt";
  static final int CANTIDAD_CADENAS = 50;
  static final int LONGITUD_CADENA = 10;


  //Genera un archivo de texto cadenasAleatorias.txt, con cadenas alfanumericas de una longitud 
  //de diez caracteres cada una.
  public static void main(String[] args) {
    try {
      BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));

      String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
      Random generador = new Random();
      String cadena;

      for (int i = 0; i < CANTIDAD_CADENAS; i++) {
        cadena = "";
        for (int j = 0; j < LONGITUD_CADENA; j++) {
          char c = alfabeto.charAt(generador.nextInt(alfabeto.length()));
          System.out.println(c);
          cadena += c;
        }
        System.out.println("Cadena " + (i + 1) + ": " + cadena);
        bufferEscritura.write(cadena + "\n");
      }

      bufferEscritura.close();
    }

    catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
          + "que queriamos leer no existe.");
    }

    catch (IOException ex) {
      System.err.println("Error leyendo o escribiendo en algun archivo.");
    }
  }
}
