package tp0.algoritmia;

import tp0.algoritmia.algoritmosOrdenamiento.QuicksortFloatDecreciente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Escuela {

  static final int CANTIDAD_ALUMNOS = 5;
  static final int CANTIDAD_ASIGNATURAS = 5;
  static final String NOMBRE_ARCHIVO = "src/tp0/algoritmia/alumnosNotas.txt";

  public static void main(String[] args) {

    ArrayList<ArrayList> matrizAlumnoNotas = new ArrayList<ArrayList>(CANTIDAD_ALUMNOS);

    try {
      BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
      Scanner sc = new Scanner(buff);

      for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
        ArrayList alumnoAux = new ArrayList();
        alumnoAux.add(sc.next());
        for (int j = 0; j < CANTIDAD_ASIGNATURAS; j++) {
          alumnoAux.add(sc.nextInt());
        }
        matrizAlumnoNotas.add(alumnoAux);
      }
      buff.close();
    } catch (FileNotFoundException ex) {
      System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
          + "que queriamos leer no existe.");
    } catch (IOException ex) {
      System.err.println("Error leyendo o escribiendo en algun archivo.");
    }

    // Muestra por pantalla las notas por alumno recientemente leidas del .txt
    imprimirAlumnosNotas(matrizAlumnoNotas);

    // Se calculan las medias de cada alumno, y luego se muestran por pantalla.
    ArrayList<Float> alumnoMedias = calcularMediaAlumnos(matrizAlumnoNotas);
    imprimirAlumnosMedias(alumnoMedias, matrizAlumnoNotas);

    // Se calculan las medias de cada asignatura, y luego se muestran por pantalla.
    float asignaturaMedias[] = calcularMediaAsignaturas(matrizAlumnoNotas);
    imprimirAsignaturasMedias(asignaturaMedias);

    // Se calculan la media total de la calse, es decir, el promedio de promedios, y
    // luego se muestra por pantalla.
    float mediaTotalClase = calcularMediaTotalClase(alumnoMedias);
    System.out.println("Media Total de la Clase: " + mediaTotalClase);

    // Se ordenan los alumnos segun su media en orden decreciente, mediante el
    // algoritmo Quicksort.
    ordenarAlumnosQuicksort(alumnoMedias, matrizAlumnoNotas);

    // Se ordenan los alumnos segun su media en orden decreciente, mediante el
    // algoritmo Seleccion.
    ordenarAlumnosSeleccion(alumnoMedias, matrizAlumnoNotas);
  }

  private static void imprimirAlumnosNotas(ArrayList<ArrayList> matriz) {
    for (int i = 0; i < matriz.size(); i++) {
      for (int j = 0; j < matriz.get(i).size(); j++) {
        System.out.print(matriz.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  // Punto a)
  private static ArrayList calcularMediaAlumnos(ArrayList<ArrayList> matriz) {
    ArrayList<Float> alumnoMediasAux = new ArrayList();
    int sumatoriaNotas;
    float mediaAlumno;

    for (int i = 0; i < matriz.size(); i++) {
      sumatoriaNotas = 0;
      for (int j = 1; j < matriz.get(i).size(); j++) {
        sumatoriaNotas += (int) ((matriz.get(i)).get(j));
      }
      mediaAlumno = (float) sumatoriaNotas / CANTIDAD_ASIGNATURAS;
      alumnoMediasAux.add(i, mediaAlumno);
    }

    return alumnoMediasAux;
  }

  private static void imprimirAlumnosMedias(ArrayList<Float> alumnoMedias, ArrayList<ArrayList> matriz) {
    System.out.println("---------------------------------------------------------");
    for (int i = 0; i < alumnoMedias.size(); i++) {
      System.out.print("Media Alumno " + matriz.get(i).get(0) + ": ");
      System.out.print(alumnoMedias.get(i));
      System.out.println();
    }
    System.out.println("----------------------------------------------------------");
  }

  // Punto b)
  private static float[] calcularMediaAsignaturas(ArrayList<ArrayList> matriz) {
    float asignaturaMediasAux[] = new float[CANTIDAD_ASIGNATURAS];

    for (int i = 0; i < matriz.size(); i++) {
      for (int j = 1; j < matriz.get(i).size(); j++) {
        asignaturaMediasAux[j - 1] += (int) matriz.get(i).get(j);
      }
    }

    for (int i = 0; i < asignaturaMediasAux.length; i++) {
      asignaturaMediasAux[i] = (float) asignaturaMediasAux[i] / CANTIDAD_ALUMNOS;
    }

    return asignaturaMediasAux;
  }

  private static void imprimirAsignaturasMedias(float[] asignaturaMedias) {
    for (int i = 0; i < asignaturaMedias.length; i++) {
      System.out.println("Media Asignatura " + (i + 1) + ": " + asignaturaMedias[i]);
    }
    System.out.println("----------------------------------------------------------");
  }

  // Punto c)
  private static float calcularMediaTotalClase(ArrayList<Float> alumnoMedias) {
    float valorMediaTotal = 0;

    for (int i = 0; i < alumnoMedias.size(); i++) {
      valorMediaTotal += alumnoMedias.get(i);
    }
    valorMediaTotal = valorMediaTotal / CANTIDAD_ALUMNOS;

    return valorMediaTotal;
  }

  // Punto d)
  private static void ordenarAlumnosQuicksort(ArrayList<Float> alumnoMedias, ArrayList<ArrayList> matriz) {
    float[] alumnoMediasAux = new float[CANTIDAD_ALUMNOS];

    for (int i = 0; i < alumnoMedias.size(); i++) {
      alumnoMediasAux[i] = alumnoMedias.get(i);
    }

    QuicksortFloatDecreciente.quicksort(alumnoMediasAux, 0, alumnoMediasAux.length - 1);

    System.out.println("----------------------------------------------------------");
    System.out.println("Listado de Alumnos Ordenados - Quicksort");
    for (int i = 0; i < alumnoMediasAux.length; i++) {
      System.out
          .println("Alumno " + matriz.get(alumnoMedias.indexOf(alumnoMediasAux[i])).get(0) + ": " + alumnoMediasAux[i]);
    }
  }

  // Punto d)
  public static void ordenarAlumnosSeleccion(ArrayList<Float> alumnoMedias, ArrayList<ArrayList> matriz) {
    float[] alumnoMediasAux = new float[CANTIDAD_ALUMNOS];

    for (int i = 0; i < alumnoMedias.size(); i++) {
      alumnoMediasAux[i] = alumnoMedias.get(i);
    }

    // Algoritmo de Seleccion
    int n = alumnoMediasAux.length;
    for (int i = 0; i < n - 1; i++) {
      int index = i;
      float max = alumnoMediasAux[i];
      for (int j = i + 1; j < n; j++) {
        if (alumnoMediasAux[j] > alumnoMediasAux[index]) {
          index = j;
          max = alumnoMediasAux[j];
        }
      }
      float t = alumnoMediasAux[index];
      alumnoMediasAux[index] = alumnoMediasAux[i];
      alumnoMediasAux[i] = t;
    }

    System.out.println("----------------------------------------------------------");
    System.out.println("Listado de Alumnos Ordenados - Seleccion");
    for (int i = 0; i < alumnoMediasAux.length; i++) {
      System.out
          .println("Alumno " + matriz.get(alumnoMedias.indexOf(alumnoMediasAux[i])).get(0) + ": " + alumnoMediasAux[i]);
    }
  }
}
