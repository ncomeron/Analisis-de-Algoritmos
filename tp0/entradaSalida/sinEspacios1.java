package tp0.entradaSalida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class sinEspacios1 {
 // Este metodo utiliza un archivo de entrada (mate.txt) que contenga un texto  // con varias palabras y varias lıneas de texto y uno o mas espacios en blanco  
 // entre  ellas, genera un arhivo de salida (sinEspacios1.txt) con el mismo 
 // texto pero eliminando todos los espacios en blanco
    public static void main(String[] args) {

        String nombreArchivoEntrada = "mate.txt";
        String nombreArchivoSalida = "sinEspacios1.txt";

        String linea = null;

        try {

            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);

            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            while ((linea = bufferLectura.readLine()) != null) {
        
                String lineaSinEspacios = linea.replaceAll(" ", "");

                System.out.println(lineaSinEspacios);
                bufferEscritura.write(lineaSinEspacios);
            }

            bufferLectura.close();
            bufferEscritura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
  
}


