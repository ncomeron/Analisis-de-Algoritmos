package tp2_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tp0.algoritmia.algoritmosOrdenamiento.QuicksortLista;

public class Ejercicio3_3 {

    static final int LONGITUD_L1 = 50;
    static final int LONGITUD_L2 = 100;
    static final int MAX_VALOR = 100;
    static final String NOMBRE_ARCHIVO_L1 = "src/tp2_2/l1.txt";
    static final String NOMBRE_ARCHIVO_L2 = "src/tp2_2/l2.txt";

    static int cantTotalComparaciones = 0;

    public static void main(String[] args) {

        /* Se crean dos archivos .txt con numeros aleatorios, con una longitud (cant elem) y rango de valores 
           Es decir, son las listas l1 y l2 que luego vamos a leer y guardar en las List<Integer>
           Una vez generados los .txt, se pueden comentar                                                  */
        //generarLista(LONGITUD_L1, MAX_VALOR, NOMBRE_ARCHIVO_L1);
        //generarLista(LONGITUD_L2, MAX_VALOR, NOMBRE_ARCHIVO_L2);
        
        // Se leen los archivos .txt creados, y asignan a las correspondientes listas
        List<Integer> l1 = leerLista(LONGITUD_L1, NOMBRE_ARCHIVO_L1);
        List<Integer> l2 = leerLista(LONGITUD_L2, NOMBRE_ARCHIVO_L2);
        
        // Ordenamos ambas listas
        QuicksortLista.quicksort(l1, 0, l1.size() - 1);
        QuicksortLista.quicksort(l2, 0, l2.size() - 1);
        
        List<Integer> elementosComunes = new ArrayList<>();
        
        /* Para testear con poquitos casos 
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> elementosComunes = new ArrayList<>();

        l1.add(3);
        //l1.add(4);
        
        l2.add(0);
        l2.add(1);
        l2.add(2);
        l2.add(3);
         */
        
        List<Integer> clonL2 = new ArrayList<>();
        clonL2.addAll(l2);

        int i = 0;
        while ((i < l1.size()) && !(clonL2.isEmpty())) {
            if (buscarElemento(l1.get(i), clonL2)) 
                elementosComunes.add(l1.get(i));
            
            i++;
        }

        // De aca en adelante, repetitivas para mostrar las salidas por pantalla
        System.out.print("l1 = [ ");
        for (int j = 0; j < l1.size(); j++) {
            System.out.print(l1.get(j) + " ");
        }
        System.out.println("]");

        System.out.print("l2 = [ ");
        for (int j = 0; j < l2.size(); j++) {
            System.out.print(l2.get(j) + " ");
        }
        System.out.println("]");

        System.out.print("elementosComunes = [ ");
        for (int j = 0; j < elementosComunes.size(); j++) {
            System.out.print(elementosComunes.get(j) + " ");
        }
        System.out.println("]");

        System.out.println("Cantidad Total de Comparaciones realizadas: " + cantTotalComparaciones);

        System.out.print("Elementos restantes de clonL2 = [ ");
        for (int j = 0; j < clonL2.size(); j++) {
            System.out.print(clonL2.get(j) + " ");
        }
        System.out.println("]");
    }

    // Metodo que realiza la busqueda binaria de un elemento, retornando un boolean con el resultado
    private static boolean buscarElemento(int n, List<Integer> clonL2) {
        boolean elementoEncontrado = false;
        int inicio = 0;
        int fin = clonL2.size() - 1;
        int indice;

        while ((inicio <= fin) && !elementoEncontrado) {
            indice = (inicio + fin) / 2;         // Se establece la posicion que determina el medio en la lista 
            //System.out.print(n +" vs "+clonL2.get(indice)+" | "); Usado para test
            if (n > clonL2.get(indice))     // Si es mayor, se descarta la parte izquierda de la lista recorrida
                inicio = indice + 1;
            else {
                if (n < clonL2.get(indice)) // Si es menor, se descarta la parte derecha de la lista recorrida
                    fin = indice - 1;
                else {                           // Caso contrario, el elemento fue encontrado y se remueve de la lista para que no afecte en las siguientes busquedas
                    elementoEncontrado = true;
                    clonL2.remove(indice);
                }
            }
            cantTotalComparaciones++;            // Acumula una comparacion entre elementos por iteracion
        }
        //System.out.println(elementoEncontrado+" - "); Usado para test
        return elementoEncontrado;
    }

    private static void generarLista(final int LONGITUD_LISTA, final int MAX_VALOR, final String NOMBRE_ARCHIVO_LISTA) {
        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_LISTA));
            Random generador = new Random();
            for (int i = 0; i < LONGITUD_LISTA; i++) {
                int num = generador.nextInt(MAX_VALOR);
                buff.write(num + "\n");
                //System.out.println(num);
            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    private static List<Integer> leerLista(final int LONGITUD_LISTA, final String NOMBRE_ARCHIVO_LISTA) {
        List<Integer> unaLista = new ArrayList<>();
        try {
            BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO_LISTA));
            for (int i = 0; i < LONGITUD_LISTA; i++) {
                unaLista.add(Integer.parseInt(buff.readLine()));
            }
            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        return unaLista;
    }

}
