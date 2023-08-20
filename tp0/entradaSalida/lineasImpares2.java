package tp0.entradaSalida;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lineasImpares2 {
    // En este metodo utilizamos el mismo metodo de entrada que el punto 1
     // ( mate.txt) y genera un archivo de salida (lineasImpares.txt) con las 
    // lineas impares del texto
    public static void main(String[] args) {
        String nombreArchivoEntrada = "src/tp0/entradaSalida/mate.txt";
        String nombreArchivoSalida = "src/tp0/entradaSalida/lineasImpares.txt";
    
        String linea = null;

        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
        
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            
            int n = 1;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
                if ((n % 2) != 0)
                    bufferEscritura.write(linea +"\n");
                n++;
            }

            bufferLectura.close();
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
